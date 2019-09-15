function validateForm() {
    var first_name = this.document.forms["registration_form"]["fname"].value;
    var last_name = document.forms["registration_form"]["lname"].value;
    var email = document.forms["registration_form"]["email"].value;
    var password = document.forms["registration_form"]["pass1"].value;
    var conf_password = document.forms["registration_form"]["pass2"].value;
    var street = document.forms["registration_form"]["street"].value;
    var city = document.forms["registration_form"]["city"].value;
    var province = document.forms["registration_form"]["province"].value;
    var country = document.forms["registration_form"]["country"].value;
    var zipCode = document.forms["registration_form"]["zipcode"].value;

    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

  
    
    if (first_name == null || first_name == "") {
        alert("First name must be filled out");
        return false;
    }
    
    else if(last_name == null || last_name == "")
    {
    	alert("Last name must be filled out");
        return false;
    }
    
    else if(email == null || email == "")
    {
    	alert("Email must be filled out");
    	return false;
    }
    
    else if(!filter.test(email)) 
    {
        alert('Please provide a valid email address');
        email.focus;
        return false;
    }
    else if(password == null || password == "")
    {
    	alert("Password must be filled out");
    	return false;
    }
    
    
    else if(conf_password == null || conf_password == "")
    {
    	alert("Confirmation password must be filled out");
    	return false;
    }
    
    else if (password != conf_password)
    {
    	alert("Passwords must match!");
    	return false;
    }
    
    else if (password.length < 6)
    {
    	alert("Passwords must be at least six characters!");
    	return false;
    }
    
    else if(street == null || street == "")
    {
    	alert("Street must be filled out");
    	return false;
    }
    
    else if(city == null || city == "")
    {
    	alert("City must be filled out");
    	return false;
    }
    
    else if(province == null || province == "")
    {
    	alert("Province must be filled out");
    	return false;
    }
    
    else if(country == null || country == "")
    {
    	alert("Country must be filled out");
    	return false;
    }
    
    else if(zipCode == null || zipCode == "")
    {
    	alert("Zipcode must be filled out");
    	return false;
    }
    
}