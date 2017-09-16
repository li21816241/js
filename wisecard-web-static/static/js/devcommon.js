function wrapdev( obj){
    obj.open = function( data ){
        obj.fireEvent( 'oncomplete' );
    }
}