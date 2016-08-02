

function isEmpty(id) {
	var x = document.getElementById(id).value;
	if (x == "" || x == null) {
		document.getElementById(id).setAttribute("aria-describedby","inputError2Status");
		return false;
	}
	return true;
}

function compare(value1, value2) {
	if (document.getElementById(value1).value == document.getElementById(value2).value) {
		return true;
	}
	return false;
}

function checkMyRegister() {
//	alert("1");
	var result = true;
	result = result && isEmpty("firstName");
	result = result && isEmpty("lastName");
	result = result && isEmpty("userName");
	result = result && isEmpty("email");
	result = result && isEmpty("password");
	result = result && isEmpty("confirmpassword");
	result = result && isEmpty("cellPhone");
	result = result && compare("password", "confirmpassword");
	
	
	if (result == false) {
		document.getElementById("message").style.visibility = "visible";
	}
	return result;
	
}

function isRealValue(obj){
	 return obj && obj !== "null" && obj !== "undefined";
}

function checkAccount() {
	var validateResult = $("#frm-Account").valid();
	
	if (validateResult ==  true ) {
		$.ajax({
			type : "POST",
			url : "getAccountById",
			datatype:"json",
			data : {"accountNumber" : $("#accountNumber").val()},
			success : function(result) {
				if (!isRealValue(result)) {
					$("#bodyMessage").html("Account not found!");
					$("#message").modal('show');
				}
				console.log(result);
				$("#firstname").val(result.firstName);
				$("#midname").val(result.midName);
				$("#lastname").val(result.lastName);
				$("#address1").val(result.address1);
				$("#address2").val(result.address2);
				$("#phoneNum1").val(result.phoneNum1);
				$("#phoneNum2").val(result.phoneNum2);
			},
			error : function(result){
				console.log(result);
				alert("Error while request..");
			}
		});
	}
	
}

function checkTargetAccount() {
	var validateResult = $("#frm-targetAccount").valid();
	
	if (validateResult ==  true) {
		$.ajax({
			type : "POST",
			url : "getAccountById",
			data : {"accountNumber" : $("#targetaccountNumber").val()},
			success : function(result) {
				if (!isRealValue(result)) {
					$("#bodyMessage").html("Account not found!");
					$("#message").modal('show');
				}
				
				$("#targetfirstname").val(result.firstName);
				$("#targetmidname").val(result.midName);
				$("#targetlastname").val(result.lastName);
				$("#targetaddress1").val(result.address1);
				$("#targetaddress2").val(result.address2);
				$("#targetphoneNum1").val(result.phoneNum1);
				$("#targetphoneNum2").val(result.phoneNum2);
			},
			error : function(){
				alert("Error while request..");
			}
		});
	}
}

function goHome() {
	location.href = "../userhome";
}


function addFund() {
	var validateResult = $("#frm-Account").valid();
	validateResult = $("#frm-amount").valid() && validateResult;
	
	if (validateResult == true) {
		$.ajax ({
			type : "POST",
			url : "addFund",
			data : {"accountNumber" : $("#accountNumber").val(),
				"amount" : $("#amount").val()},
				success : function(result) {
					$("#bodyMessage").html(result);
					$("#message").modal('show');
				},
				error : function(){
					$("#bodyMessage").html("Error");
					$("#message").modal('show');
				}
		});
	}
	
}

function tranferBySupport() {
	var validateResult = $("#frm-AddFund").valid();
	validateResult = $("#frm-targetAccount").valid() && validateResult;
	validateResult = $("#frm-amount").valid() && validateResult;
	
	if (validateResult == true) {
		$.ajax ({
			type : "POST",
			url : "transferBySupport",
			data : {"sendAccount" : $("#accountNumber").val(),
				"targetAccount" : $("#targetaccountNumber").val(),
				"amount" : $("#amount").val()},
				success : function (result) {
					$("#bodyMessage").html(result.message);
					$("#message").modal('show');
				},
				error : function(){
					$("#bodyMessage").html("Error");
					$("#message").modal('show');
				}
		});
	}
}

function transferByUser() {
	var validateResult = $("#frm-transfer").valid();
	
	if (validateResult ==  true) {
		$.ajax ({
			type : "POST",
			url : "transferByUser",
			data : {"targetAccount" : $("#targetAccount").val(),
				"amount" : $("#amount").val()},
				success : function (result) {
					$("#bodyMessage").html(result.message);
					$("#message").modal('show');
				},
				error : function(result){
					$("#bodyMessage").html("Error");
					$("#message").modal('show');
				}
		});
	}
	
}
function transferTargetID() {
	var validateResult = $("#frm-transfer").valid();
	
	if (validateResult ==  true) {
		$.ajax ({
			type : "POST",
			url : "transferTargetID",
			data : {"targetAccount" : $("#targetAccount").val(),
				"amount" : $("#amount").val()},
				success : function (result) {
					$("#bodyMessage").html(result.message);
					$("#message").modal('show');
				},
				error : function(){
					$("#bodyMessage").html("Error");
					$("#message").modal('show');
				}
		});
	}
}

function withdraw() {
	var validateResult = $("#frm-AddFund").valid();
	validateResult = $("#frm-amount").valid() && validateResult;
	
	if (validateResult == true) {
		$.ajax ({
			type : "POST",
			url : "withdraw",
			data : {"accountNumber" : $("#accountNumber").val(),
				"amount" : $("#amount").val()},
				success : function(result) {
					$("#bodyMessage").html(result.message);
					$("#message").modal('show');
				},
				error : function(){
					$("#bodyMessage").html("Error");
					$("#message").modal('show');
				}
		});
	}
}

function addTargetAccount() {
	var validateResult = $("#frm-Addtarget").valid();
	
	if (validateResult == true) {
		$.ajax ({
			type : "POST",
			url : "addTargetAccount",
			data : $("#frmAddtarget").serialize(),
			success : function (result) {
				$("#bodyMessage").html(result.message);
				$("#message").modal('show');
			},
			error : function () {
				$("#bodyMessage").html("Error");
				$("#message").modal('show');
			}
		});
	}
}

function modifyTargetAccount() {
	var validateResult = $("#frm-modify").valid();
	
	if (validateResult) {
		$.ajax ({
			type : "POST",
			url : "modifyTargetAccount",
			data : {"idTarget" : $("#md_Id").val(),
				"idAccountTarget" : $("#md_accountId").val(),
				"name" : $("#md_name").val()},
				success : function (result) {
					$("#bodyMessage").html(result.message);
					$("#message").modal('show');
					
					if (result.state == true) {
						$("#modifyTargetAccount").modal('hide');
					}
				},
				error : function () {
					$("#bodyMessage").html("Error");
					$("#message").modal('show');
				}
		});
	}
}

function deleteTargetAccount() {
	$.ajax ({
		type : "POST",
		url : "deleteTargetAccount",
		data : {"idTarget" : $("#md_Id").val()},
		success : function (result) {
			$("#bodyMessage").html(result.message);
			$("#message").modal('show');
			
			if (result.state == true) {
				$("#deleteTargetAccount").modal('hide');
			}
		},
		error : function () {
			$("#bodyMessage").html("Error");
			$("#message").modal('show');
			$("#deleteTargetAccount").modal('hide');
		}
	});
}

function loadInfoAdmin() {
	$.ajax({
		type : "POST",
		url : "infoHomeAdmin",
		success : function(result) {
			/* nav */
			$("#countverifyTransactionnav").html(result.countverifyTransaction);
			$("#countChangeStateNewToActivenav").html(result.countChangeStateNewToActive);
			$("#countChangeTateDisableToRemovenav").html(result.countChangeTateDisableToRemove);
			$("#countOfAccount").html(result.countChangeStateNewToActive + result.countChangeTateDisableToRemove)
			/* body */
			try {
				$("#countverifyTransaction").html(result.countverifyTransaction);
				$("#countChangeStateNewToActive").html(result.countChangeStateNewToActive);
				$("#countChangeTateDisableToRemove").html(result.countChangeTateDisableToRemove);
			} catch (err){}
		}
	});
}


