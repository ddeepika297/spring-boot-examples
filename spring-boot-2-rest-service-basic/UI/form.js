$(document).ready(function() {

    // process the form
    $('#createStudent').submit(function(event) {

        // get the form data
        // there are many ways to get this data using jQuery (you can use the class or id also)
        var formData = {
            'name': $('input[name=name]').val(),
            'student_id': $('input[name=student_id]').val(),
            'branch': $('input[name=branch]').val(),
            'semester': $('input[name=semester]').val()
        };




        // process the form
        $.ajax({
            type: 'POST', // define the type of HTTP verb we want to use (POST for our form)
            url: 'http://localhost:8080/students', // the url where we want to POST
            data: formData,
            async: false,
        }).always(nextStep);


        function nextStep(a, textStatus, b) {

            if (textStatus === 'success') {
                
                alert("Student created successfully");
            } else {
                // failure
                alert('Failed !!');
            }
        }


    });
});