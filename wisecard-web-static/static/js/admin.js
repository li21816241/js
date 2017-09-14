/*!
 * Start Bootstrap - YPS  Public Transit Platform v3.3.7+1 (http://startbootstrap.com/template-overviews/admin)
 * Copyright 2013-2016 Start Bootstrap
 * Licensed under MIT (https://github.com/BlackrockDigital/startbootstrap/blob/gh-pages/LICENSE)
 */
// dev or NOT?
var devMode = false;

$(function() {
    $('#side-menu').metisMenu();
});

//Loads the correct sidebar on window load,
//collapses the sidebar on window resize.
// Sets the min-height of #page-wrapper to window size
$(function() {
    $(window).bind("load resize", function() {
        var topOffset = 50;
        var width = (this.window.innerWidth > 0) ? this.window.innerWidth : this.screen.width;
        if (width < 768) {
            $('div.navbar-collapse').addClass('collapse');
            topOffset = 100; // 2-row-menu
        } else {
            $('div.navbar-collapse').removeClass('collapse');
        }

        var height = ((this.window.innerHeight > 0) ? this.window.innerHeight : this.screen.height) - 1;
        height = height - topOffset;
        if (height < 1) height = 1;
        if (height > topOffset) {
            $("#page-wrapper").css("min-height", (height) + "px");
        }
    });

    var url = window.location;
    // var element = $('ul.nav a').filter(function() {
    //     return this.href == url;
    // }).addClass('active').parent().parent().addClass('in').parent();
    var element = $('ul.nav a').filter(function() {
        return this.href == url;
    }).addClass('active').parent();

    while (true) {
        if (element.is('li')) {
            element = element.parent().addClass('in').parent();
        } else {
            break;
        }
    }
});

// welcome
$(function(){
    // show different page
    var user = window.sessionStorage.getItem('login.user'),
        welcome = "Welcome you, Guest.";
    if(user == 'teller') {
        welcome = "Welcome you, Test Teller (959000001).";
    } else if(user == 'admin') {
        welcome = "Welcome you, Test Admin (959000009).";
    } else if(user == 'supervisor') {
        welcome = "Welcome you, Test Supervisor (959000002).";
    } else if(user != null){
        welcome = "Welcome you, " + user + ".";
    }
    if($('.navbar .welcome')) {
        $('.navbar .welcome').text(welcome);
    }

    //show different menu
    if(user == 'teller') {
        $('.navbar .forms').removeClass('hide');
    } else if(user == 'admin') {
        $('.navbar .admins').removeClass('hide');
    } else if(user == 'supervisor') {
        $('.navbar .inspects').removeClass('hide');
    }

    //show messages count
    setInterval(function(){
        $.ajax({
            url         : '/rest/message/unread/' + user,
            dataType    : 'json',
            data        :  JSON.stringify({}),
            type        : 'post',
            contentType : 'application/json',
            success     : function(data){
                if(data && data.count) {
                    $('.badge').text(data.count);
                } else {
                    $('.badge').text('');
                }
            },
            error       : function(err){
                console.log(err);
            }
        });
    }, 60000);
});


//login
function login(user, password, callback) {
    var valid = false;
    if(devMode) {
        if (user == 'teller' && password != 'teller') {
            valid = false;
        } else if (user == 'admin' && password != 'admin') {
            valid = false;
        } else if (user == 'supervisor' && password != 'supervisor') {
            valid = false;
        } else if (user != 'teller' && user != 'admin' && user != 'supervisor') {
            valid = false;
        } else {
            valid = true;
        }
        if(callback || '') {
          callback(valid);
        }
    } else {
      var param = {};
      param.userName = user;
      param.passCode = password;

      $.ajax({
        url         : '/rest/authen/login?' + Math.random(),
        dataType    : 'json',
        data        :  JSON.stringify(param),
        type        : 'post',
        contentType : 'application/json',
        async       : 'false',
        success     : function(data) {
          if(data && data.resultCode == 'SUCCESS') {
            valid = true;
          } else {
            valid = false;
          }
          if(callback || '') {
            callback(valid);
          }
        },
        error       : function(err) {
          valid = false;
          if(callback || '') {
            callback(valid);
          }
        }
      });
    }
}
