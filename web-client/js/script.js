$(document).ready(function () {
    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
    $('.collapsible').collapsible();
    $('select').material_select();
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
                if(data.session != ""){
					alert($.cookie("session"));
                    $.cookie("session", data.session);
					$.cookie("username", data.username);
					$.cookie("name", data.name);
                    window.location.replace("/customer.html");
                }
                else{
					alert('error');
                    window.location.replace("/");
                }
                
                
            },

            failure: function (errMsg) {
                alert(errMsg);
            },
            dataType: "json",
            contentType: "application/json"
        });
    };

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
	 $('input#switch').change(function() {
        alert('whoah!');  
    });


    //Add by Brand
    $(document).on("click", "table#branch-table tbody tr", function () {
            //var counter-id = $(this).find("td.td-id");
            var brand = $(this).find("td:nth-child(1)").text();
            //var latitude = 14.5624372;
            //var longitude 121.019279;
            var selected = $(this).hasClass("teal lighten-2");
            $("#branch-table tr").removeClass("teal lighten-2");
            if (!selected){
                $(this).addClass("teal lighten-2");
                $("a#btn-join").removeClass("disabled");
                $(document).on("click", "a#btn-join",function(){
                    alert(brand);
                    /*
                    $.ajax({
                    type: "POST",
                    url: "/ws/account/join/brand",
                    // The key needs to match your method's input parameter (case-sensitive).
                    data: JSON.stringify({"brandcategory": $('#register-username').val(), "latitude" : latitude, "longitude" : longitude, session" : $cookie.('session')),
                    success: function (data) {
                        alert('Joined Queue');
                        //Add successfully registered text above login button here
                    },

                    failure: function (errMsg) {
                        alert(errMsg);
                    },
                    dataType: "json",
                    contentType: "application/json"
        

                    });
                    */


                    });
            }
            
        //table-row
    });


    //Add by Category
    $(document).on("click", "a#btn-join-category", function(){
        alert($('#slct-category option:selected').text());
        //Add AJAX left
    });



/*
        //Adds Table
    $('#switcaahbox').prop('checked') {
        //Adds Table Headers
        $("table#branch-table").html("<thead><th>id[hidden]</th><th>Counter</th><th>Brand</th><th>Branch</th><th>Category</th></thead><tbody>");
        //Will add pagination later
		
		 $.ajax({
            type: "POST",
            url: "/ws/branch/search",
            // The key needs to match your method's input parameter (case-sensitive).
            data: JSON.stringify({"brand":$('#search').val(), "session":$.cookie('session').toString()}),
            success: function (data) {
                for(var i= 0; i < data.list.length; i++)
				{
					 $("table#branch-table").append("<tr><td class='td-id'>" + data.list[i].id + "</td><td>" + data.list[i].counter + " </td><td>" + data.list[i].brand + "</td><td>" + data.list[i].branch + "</td><td>" + data.list[i].category + "</td></tr>");
				}	
		
            },

            failure: function (errMsg) {
                alert(errMsg);
            },
            dataType: "json",
            contentType: "application/json"
        });
		
        
        $("table#branch-table").append("</tbody>");


	
	//btn-search
});
*/
});
