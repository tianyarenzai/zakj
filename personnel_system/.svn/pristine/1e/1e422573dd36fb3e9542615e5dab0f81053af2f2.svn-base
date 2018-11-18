// JavaScript Document

function FocusItem(obj) {
	obj.parentNode.parentNode.className = "current";
	var msgBox = obj.parentNode.getElementsByTagName("span")[0];
	msgBox.innerHTML = "";
	msgBox.className = "";
}

function CheckItem(obj) {
	obj.parentNode.parentNode.className = "";
	var msgBox = obj.parentNode.getElementsByTagName("span")[0];
	switch (obj.name) {
		case "idnumber":
			if(obj.value != "") {
				var code=obj.value;
				var regcode=/(^\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/;
				if(regcode.test(code)==false){
					msgBox.innerHTML="格式有误";
					msgBox.className="error";
				}
			}
			break;
			
		case "postcode":
			if(obj.value != "" && obj.value != 0) {
				var email=obj.value;
				var reg=/^[1-9][0-9]{5}$/;
				if(reg.test(email)==false){
					msgBox.innerHTML="格式有误";
					msgBox.className="error";
					return false;
				}
			}
			break;
			
		case "age":
			if(obj.value != "" && obj.value != 0) {
				var email=obj.value;
				var reg=/^(?:[1-9][0-9]?|1[01][0-9]|120)$/;
				if(reg.test(email)==false){
					msgBox.innerHTML="格式有误";
					msgBox.className="error";
					return false;
				}
			}
			break;
			
		case "phone":
			if(obj.value != "") {
				var mobile=obj.value;
				var reg=/^1\d{10}$/;
				if(reg.test(mobile)==false){
					msgBox.innerHTML="格式有误";
					msgBox.className="error";
					return false;
				}
			}
			break;
		case "inphone":
			if(obj.value != "") {
				var mobile=obj.value;
				var reg=/^(\(\d{3,4}\)|\d{3,4}-)?\d{7,8}(-\d{1,4})?$/;
				if(reg.test(mobile)==false){
					msgBox.innerHTML="格式有误";
					msgBox.className="error";
					return false;
				}
			}
			break;
			
	}
	return true;
}


function changepic(pic)
{
   var url ='Code.jsp?t='+new Date().getTime();
   pic.src=url;
}

var xmlhttp;

function createXmlHttpRequest()
{
	try {
		xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
		try {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (e) {
			try {
				xmhttp = new XMLHttpRequest();
				if (xmlhttp.overrideMimeType) {
					xmlhttp.overrideMimeType("text/xml");
				}
			} catch (e) {			}
		}
	}
}




function checkForm(frm) {
	var els = frm.getElementsByTagName("input");
	for ( var i = 0; i < els.length; i++) {
		if (typeof (els[i].getAttribute("onblur")) == "function") {
			if (!CheckItem(els[i]))
				return false;
		}
	}
	return true;
}

function openRoom() {
	window.open("chat-room.jsp", "chater",
			"status=0,MaxButton=false,scrollbars=0,menubar=0,location=0,width=600,height=450");
}

function scrollChater() {
	var chater = document.getElementById("chater");
	var scrollTop = document.documentElement.scrollTop;
	var scrollLeft = document.documentElement.scrollLeft;
	chater.style.left = scrollLeft + document.documentElement.clientWidth - 92
			+ "px";
	chater.style.top = scrollTop + document.documentElement.clientHeight - 25
			+ "px";
}

function inArray(array, str) {
	for (a in array) {
		if (array[a] == str)
			return true;
	}
	return false;
}

function setCookie(name, value) {
	var Days = 30;
	var exp = new Date();
	exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
	document.cookie = name + "=" + escape(value) + ";expires="
			+ exp.toGMTString();
}

function getCookie(name) {
	var arr = document.cookie
			.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
	if (arr != null)
		return unescape(arr[2]);
	return null;
}

function delCookie(name) {
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	var cval = getCookie(name);
	if (cval != null)
		document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}

function creatXMLHttpRequest()
{
	try{
	    xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
	}catch(e){
	    try{
	         xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	    }catch(e){
	         xmlhttp = false;
	    }
	}
	
	if(!xmlhttp && typeof XMLHttpRequest != 'undefined'){
	    xmlhttp = new XMLHttpRequest();
	}
}

