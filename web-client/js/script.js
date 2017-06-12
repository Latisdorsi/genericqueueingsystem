$(document).ready(function () {
    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
    $('ul.tabs').tabs();
    $('.modal').modal();
    $('.button-collapse').sideNav({
        menuWidth: 500, // Default is 300
        edge: 'right', // Choose the horizontal origin
        closeOnClick: false, // Closes side-nav on <a> clicks, useful for Angular/Meteor
        draggable: false// Choose whether you can drag to open on touch screens
    }
    );

    function LoginAJAXRequest() {
        $.ajax({
            type: "POST",
            url: "/ws/account/login",
            // The key needs to match your method's input parameter (case-sensitive).

            data: JSON.stringify({"username": $('#login-username').val(), "password": $('#login-password').val()}),
            crossDomain: true,
            success: function (data) {
                $.cookie("session", data.session);
                alert('Session cookie is: ' + $.cookie("session") + ' [For debugging purposes]');
                window.location.replace("/customer.html");
            },

            failure: function (errMsg) {
                alert(errMsg);
            },
            dataType: "json",
            contentType: "application/json"
        });
    }
    ;
    $('.login-input').keypress(function (e) {
        if (e.which == 13) {
            LoginAJAXRequest();
            return false;    //<---- Add this line
        }
    });
    //Login Button Function
    $('#btn-login').click(function () {
        LoginAJAXRequest();
    });

    $('#btn-register').click(function () {
        $.ajax({
            type: "POST",
            url: "/ws/account/create/customer",
            // The key needs to match your method's input parameter (case-sensitive).
            data: JSON.stringify({"username": $('#register-username').val(), "password": $('#register-password').val(), "name": $('#register-name').val(), "type": "NORMAL"}),
            success: function (data) {
                $('#modal1').modal('close');
                //Add successfully registered text above login button here
            },

            failure: function (errMsg) {
                alert(errMsg);
            },
            dataType: "json",
            contentType: "application/json"
        });

    });
    //Adds Table
    $('#btn-search').click(function () {
        //Adds Table Headers
        //    $( "table#branch-table" ).html( "<p> works dawg!</p>");
        $("table#branch-table").html("<thead><th>id[hidden]<th><th>Brand</th><th>Branch</th><th>Category</th></thead><tbody>");
        //Will add pagination later
        for (var i = 0; i <= 5; i++) {
            $("table#branch-table").append("<tr><td>" + i + "<td><td>Samsung</td><td>SM North</td><td>Tech and Gadgets Store</td></tr>");
        }
        ;
        $("table#branch-table").append("</tbody>");

        $("table#branch-table tbody tr").click(function () {
            var selected = $(this).hasClass("teal darken-2");
            $("#branch-table tr").removeClass("teal darken-2");
            if (!selected)
                $(this).addClass("teal darken-2");
            $("a#btn-join").removeClass("disabled")

        });
    });




});


