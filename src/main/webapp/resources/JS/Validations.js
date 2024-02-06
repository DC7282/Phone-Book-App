var nameval=0;
var emailval=0;
var contactval=0;
var usernameval=0;
var passwordval=0;
var addressval=0;

function myEmail(){
	var email = document.getElementById("email").value;
	if (email.indexOf("@") <= 0) {
		document.getElementById("msgemail").innerHTML = "email must be @";
		document.getElementById("msgemail").style.color = "red";
		emailval=0;
	}
	else if ((email.charAt(email.length - 4)) != '.' && (email.charAt(email.length - 3)) != '.') {
		document.getElementById("msgemail").innerHTML = "invalid email";
		document.getElementById("msgemail").style.color = "red";
		emailval=0;
	}
	else {
		let xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange=function(){
			if(this.readyState==4 && this.status==200){
				if(this.responseText=="available"){
					document.getElementById("msgemail").innerHTML ="";
					emailval=1;
				}else{
					document.getElementById("msgemail").innerHTML ="Email already exist";
					document.getElementById("msgemail").style.color = "red";
					emailval=0;
				}		
			}
		}
		xhttp.open("GET","checkemail?sendEmail="+email,true);
		xhttp.send();
	}
}

function myUsername(){
	var username = document.getElementById("username").value;
	if (username.indexOf("@") <= 0) {
		document.getElementById("msguname").innerHTML = "Username must be @";
		document.getElementById("msguname").style.color = "red";
		usernameval=0;
	}
	else if ((username.charAt(username.length - 4)) != '.' && (username.charAt(username.length - 3)) != '.') {
		document.getElementById("msguname").innerHTML = "invalid Username";
		document.getElementById("msguname").style.color = "red";
		usernameval=0;
	}
	else {
		let xhttp=new XMLHttpRequest();
		xhttp.onreadystatechange=function(){
			if(this.readyState==4 && this.status==200)
			{
				if(this.responseText=="available")
				{
					document.getElementById("msguname").innerHTML = "";
					usernameval=1;
				}else{
					document.getElementById("msguname").innerHTML = "Username already exist";
					document.getElementById("msguname").style.color = "red";
					usernameval=0;
				}
			}
			
		}
		xhttp.open("GET","checkusername?sendUsername="+username,true);
		xhttp.send();	
	}
}

function myName() {
	var name = document.getElementById("name").value;
	var regExp = /^[a-zA-z ]+$/
	if (name == "") {
		document.getElementById("msgname").innerHTML = "name should not be blank";
		document.getElementById("msgname").style.color = "red";
		nameval=0;
	}
	else if (name.length < 3 || name.length > 25) {
		document.getElementById("msgname").innerHTML = "name should not less than 3 and grater than 25";
		document.getElementById("msgname").style.color = "red";
		nameval=0;
	}
	else if (regExp.exec(name) != null) {
		document.getElementById("msgname").innerHTML = "";
		nameval=1;
	}
	else {
		document.getElementById("msgname").innerHTML = "invalid name";
		document.getElementById("msgname").style.color = "red";
		nameval=0;
	}
}

function myContact() {
	var num = document.getElementById("contact").value;
	if (num == "") {
		document.getElementById("msgcont").innerHTML ="invalid number";
		document.getElementById("msgcont").style.color = "red";
		contactval=0;
	}
	else if (!num.match(/^\d+$/)) {
		document.getElementById("msgcont").innerHTML = "Only digits is allowed";
		document.getElementById("msgcont").style.color = "red";
		contactval=0;
	}
	else if (num.length <= 9) {
		document.getElementById("msgcont").innerHTML="number length not less than 10 digits";
		document.getElementById("msgcont").style.color = "red";
		contactval=0;
	}
	else if (num.length >= 11) {
		document.getElementById("msgcont").innerHTML = "number length not greter than 10 digits";
		document.getElementById("msgcont").style.color = "red";
		contactval=0;
	}
	else {
		document.getElementById("msgcont").innerHTML = "";
		contactval=1;
		
		let xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange=function(){
			if(this.responseText=="available")
			{
				document.getElementById("msgcont").innerHTML = "";
				contactval=1;
			}else{
				document.getElementById("msgcont").innerHTML = "Contact already exist";
				document.getElementById("msgcont").style.color = "red";
				contactval=0;
			}		
		}
		xhttp.open("GET","checkContact?sendContact="+num,true);
		xhttp.send();
	}
}	
function myPassword(){
	var pass= document.getElementById("password").value;
	if(pass==""){
		document.getElementById("msgpass").innerHTML = "passwerd should not be blank";
		document.getElementById("msgpass").style.color = "red";
		passwordval=0;
	}
	else if(pass.length<=8 || pass.length>=15){
		document.getElementById("msgpass").innerHTML = "passwerd length should be grater than 8 and less than 15";
		document.getElementById("msgpass").style.color="red"
		passwordval=0;
	}
	else if ((pass.search(/[a-z]/)==-1) || (pass.search(/[A-Z]/)==-1) || (pass.search(/[0-9]/)==-1)){
		document.getElementById("msgpass").innerHTML = "passwerd should be at least one digit one small and one capital letter";
		document.getElementById("msgpass").style.color="red"
		passwordval=0;
	}
	else{
		document.getElementById("msgpass").innerHTML = "";
		passwordval=1;
	}
}

function myAddress(){
	var add= document.getElementById("address").value;
	if(add==""){
		document.getElementById("msgadd").innerHTML = "passwerd should not be blank";
		document.getElementById("msgadd").style.color = "red";
		addressval=0;
	}
	else{
		document.getElementById("msgadd").innerHTML = "";
		addressval=1;
	}
}

let formSubmit=()=>{
	if(nameval==1 && emailval==1 && contactval==1 && usernameval==1 && passwordval==1 && addressval==1){
		return true;
	}else{
		alert("Kindly fill all the mandatory fields");
		return false;
	}
}

let UpdateFormSubmit=()=>{
	if(nameval==1 && passwordval==1 && addressval==1){
		return true;
	}else{
		alert("Kindly fill all the mandatory fields");
		return false;
	}
}

let searchData=(data)=>{
	let xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){		
		if(this.readyState==4 && this.status==200)
		{
			document.getElementById("table").innerHTML=this.responseText;
			//console.log(this.responseText);			
		}
	}
	xhttp.open("GET","search?userSearch="+data,true);
	xhttp.send();
}