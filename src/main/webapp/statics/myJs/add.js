var s = 0;
$(function() {
	$("body")
			.on(
					"click",
					"[name='addTd']",
					function() {
						if ($("[namedd='voucherDetail.item']").val() == ""
								|| $("[namedd='voucherDetail.item']").val() == null) {
							alert("请填入费用类别！");
							return;
						} else if ($("[namedd='voucherDetail.account']").val() == ""
								|| $("[namedd='voucherDetail.account']").val() == null) {
							alert("请填入报销金额！");
							return;
						} else if ($(
								"[namedd='voucherDetail.bizClaimVoucher.event']")
								.val() == ""
								|| $(
										"[namedd='voucherDetail.bizClaimVoucher.event']")
										.val() == null) {
							alert("请填入费用说明！");
							return;
						} else {
							var trObj = $(this).parent().parent().parent()
									.clone();
							$("[names='tj_0']").attr("names", "tj_" + s);
							trObj.attr("names", "tj_" + s);
							$(".hidds").attr("readOnly", "readOnly");
							$(".hidds").css("border", "none");
							trObj.find(":input").each(function(i) {
								$(this).val("");
							});
							$(this).parent().parent().parent().after(trObj);
							if ($(trObj).children(".am-btn").length == 0) {
								$(this)
										.parent()
										.append(
												"<button type='button' name='delTd' class='am-btn am-btn-default am-btn-danger'><span class='am-icon-trash-o'></span></button>")
							}
							$(this).remove();
						}
					});
	$("#cj")
			.click(
					function() {
						if ($("[namedd='voucherDetail.item']").val() == ""
								|| $("[namedd='voucherDetail.item']").val() == null) {
							alert("请填入费用类别！");
							return;
						} else if ($("[namedd='voucherDetail.account']").val() == ""
								|| $("[namedd='voucherDetail.account']").val() == null) {
							alert("请填入报销金额！");
							return;
						} else if ($(
								"[namedd='voucherDetail.bizClaimVoucher.event']")
								.val() == ""
								|| $(
										"[namedd='voucherDetail.bizClaimVoucher.event']")
										.val() == null) {
							alert("请填入费用说明！");
							return;
						} else {
							var isFlag = true;
							$(".hidds").each(
									function() {
										if ($(this).val() == ""
												|| $(this).val() == null) {
											isFlag = false;
										} else {
											isFlag = true;
										}
									});
							if (!isFlag) {
								alert("请确定所有报销表格不为空！");
								return false;
							}
							var v = 0;
							var arr = new Array();
							$.each($("[namedd='voucherDetail.account']"),
									function() {
										arr.push($(this).val());
									});
							for (var i = 0; i < arr.length; i++) {
								if (arr[i] == null || arr[i] == "") {
									arr[i] = 0;
								}
								v += parseFloat(arr[i]);
							}
							$("#totalC").attr("value", v);
							$("#vll").attr("value", "新创建");
							
							var voucherDetail_bizClaimVoucher_event = [];
							$("[namedd='voucherDetail.bizClaimVoucher.event']")
									.each(
											function() {
												voucherDetail_bizClaimVoucher_event
														.push($(this).val());
											});
							$("[name='event']").attr(
									"value",
									voucherDetail_bizClaimVoucher_event
											.join(","));

							var voucherDetail_account = [];
							$("[namedd='voucherDetail.account']").each(
									function() {
										voucherDetail_account.push($(this)
												.val());
									});
							$("[name='account']").attr("value",
									voucherDetail_account.join(","));

							var voucherDetail_item = [];
							$("[namedd='voucherDetail.item']").each(
									function() {
										voucherDetail_item.push($(this).val());
									});
							$("[name='item']").attr("value",
									voucherDetail_item.join(","));
							
							$("#formId").submit();
						}
					});
	$("#sp")
			.click(
					function() {
						if ($("[namedd='voucherDetail.item']").val() == ""
								|| $("[namedd='voucherDetail.item']").val() == null) {
							alert("请填入费用类别！");
							return;
						} else if ($("[namedd='voucherDetail.account']").val() == ""
								|| $("[namedd='voucherDetail.account']").val() == null) {
							alert("请填入报销金额！");
							return;
						} else if ($(
								"[namedd='voucherDetail.bizClaimVoucher.event']")
								.val() == ""
								|| $(
										"[namedd='voucherDetail.bizClaimVoucher.event']")
										.val() == null) {
							alert("请填入费用说明！");
							return;
						} else {
							var isFlag = true;
							$(".hidds").each(
									function() {
										if ($(this).val() == ""
												|| $(this).val() == null) {
											isFlag = false;
										} else {
											isFlag = true;
										}
									});
							if (!isFlag) {
								alert("请确定所有报销表格不为空！");
								return false;
							}
							$("#vll").attr("value", "待审核");
							var voucherDetail_bizClaimVoucher_event = [];
							$("[namedd='voucherDetail.bizClaimVoucher.event']")
									.each(
											function() {
												voucherDetail_bizClaimVoucher_event
														.push($(this).val());
											});
							$("[name='event']").attr(
									"value",
									voucherDetail_bizClaimVoucher_event
											.join(","));

							var voucherDetail_account = [];
							$("[namedd='voucherDetail.account']").each(
									function() {
										voucherDetail_account.push($(this)
												.val());
									});
							$("[name='account']").attr("value",
									voucherDetail_account.join(","));

							var voucherDetail_item = [];
							$("[namedd='voucherDetail.item']").each(
									function() {
										voucherDetail_item.push($(this).val());
									});
							$("[name='item']").attr("value",
									voucherDetail_item.join(","));
							$("#formId").submit();
						}
					});
	$("body").on("blur", "[namedd='voucherDetail.account']", function() {
		var v = 0;
		var arr = new Array();
		$.each($("[namedd='voucherDetail.account']"), function() {
			arr.push($(this).val());
		});
		for (var i = 0; i < arr.length; i++) {
			if (arr[i] == null || arr[i] == "") {
				arr[i] = 0;
			}
			v += parseFloat(arr[i]);
		}
		$("#totalC").attr("value", v);
	});
	$("body").on("click", "[name='delTd']", function() {
		$(this).parent().parent().parent().remove();
	});
});
