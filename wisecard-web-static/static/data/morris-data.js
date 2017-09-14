$(function() {
    if(document.getElementById("morris-area-chart") || '') {
        Morris.Area({
            element: 'morris-area-chart',
            data: [{
                period: '2016 W38',
                files: 8110,
                customers: 2666,
                unit: 3000
            }, {
                period: '2016 W39',
                files: 10002,
                customers: 2778,
                unit: 3600
            }, {
                period: '2016 W40',
                files: 8002,
                customers: 2401,
                unit: 3330
            }, {
                period: '2016 W41',
                files: 9039,
                customers: 2533,
                unit: 3570
            }, {
                period: '2016 W42',
                files: 10481,
                customers: 2981,
                unit: 3520
            }, {
                period: '2016 W43',
                files: 9371,
                customers: 3036,
                unit: 3090
            }, {
                period: '2016 W44',
                files: 10086,
                customers: 3301,
                unit: 3060
            }, {
                period: '2016 W45',
                files: 9386,
                customers: 3106,
                unit: 3020
            }, {
                period: '2016 W46',
                files: 10802,
                customers: 3288,
                unit: 3290
            }],
            xkey: 'period',
            ykeys: ['unit', 'files', 'customers'],
            labels: ['Files/Customer', 'File', 'Cutomer'],
            pointSize: 2,
            hideHover: 'auto',
            resize: true
        });
    }

    if(document.getElementById("morris-donut-chart") || '') {
        Morris.Donut({
            element: 'morris-donut-chart',
            data: [{
                label: "Customers",
                value: 400
            }, {
                label: "Files",
                value: 1200
            }, {
                label: "Rejects",
                value: 20
            }],
            resize: true
        });
    }

    if(document.getElementById("morris-bar-chart") || '') {
        Morris.Bar({
            element: 'morris-bar-chart',
            data: [{
                year: '2010',
                cust: 37890,
                file: 103011
            }, {
                year: '2011',
                cust: 40281,
                file: 104011
            }, {
                year: '2012',
                cust: 40221,
                file: 110011
            }, {
                year: '2013',
                cust: 41002,
                file: 112011
            }, {
                year: '2014',
                cust: 41929,
                file: 120291
            }, {
                year: '2015',
                cust: 41290,
                file: 139029
            }, {
                year: '2016',
                cust: 43001,
                file: 159201
            }],
            xkey: 'year',
            ykeys: ['cust', 'file'],
            labels: ['Customers', 'Files'],
            hideHover: 'auto',
            resize: true
        });
    }
    
});
