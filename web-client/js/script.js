


$(document).ready(function(){
    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
    $('.modal').modal();
    $('.button-collapse').sideNav({
      menuWidth: 500, // Default is 300
      edge: 'right', // Choose the horizontal origin
      closeOnClick: false, // Closes side-nav on <a> clicks, useful for Angular/Meteor
      draggable: false// Choose whether you can drag to open on touch screens
    }
    );
    //Login Button Function
    $('#btn-login').click(function(){
    	$.ajax({
    		type: "POST",
    		url: "/ws/account/login",
   			 // The key needs to match your method's input parameter (case-sensitive).

         data: JSON.stringify({ "username": $('#login-username').val(), "password":$('#login-password').val()}),
         crossDomain: true,
         success: function(data){
          $.cookie("session", data.session);
          alert($.cookie("session"));
        },

        failure: function(errMsg) {
         alert(errMsg);
       },
       dataType: "json",
       contentType: "application/json"
     });

    });

    $('#btn-register').click(function(){
      $.ajax({
        type: "POST",
        url: "/ws/account/create/customer",
         // The key needs to match your method's input parameter (case-sensitive).
         data: JSON.stringify({  "username": $('#register-username').val(), "password":$('#register-password').val(),"name":$('#register-name').val(), "type":"NORMAL"}),
         success: function(data){
            $('#modal1').modal('close');
            //Add successfully registered text above login button here
        },

        failure: function(errMsg) {
         alert(errMsg);
       },
       dataType: "json",
       contentType: "application/json"
     });

    });
  });


