<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="bean.student"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title></title>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<link rel="stylesheet" type="text/css"
	href="assets/font-awesome/css/font-awesome.min.css">
<style type="text/css">
<%@include file="assets/css/style.css"%>
<%@include file="assets/css/bootstrap.min.css" %>
</style>

</head>
<body>
	<div class="logo">Ứng Dụng quản lý học sinh</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">

				<h3>Thêm học sinh</h3>
				<h3><%=(request.getAttribute("masseger") != null) ? request.getAttribute("masseger") : " "%></h3>
				<form action="AddstudentController" method="post" accept-charset="utf-8">
					<p>Nhập tên :</p>
					<input type="text" name="name" placeholder=""><br>
					<p>Nhập điểm toán:</p>
					<input type="text" name="mathPoint"><br>
					<p>Nhập điểm lý :</p>
					<input type="text" name="physicPoint"><br>
					<p>Nhập điểm hóa :</p>
					<input type="text" name="chemPoint"><br> Chọn lớp: <select
						name="dropdown_class">
						<c:forEach items="${listclass}" var="cl">
							<option value="${cl.classId}">${cl.className}</option>
						</c:forEach>
					</select> <input type="submit" name="submit" value="thêm học sinh">
				</form>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
				<h3>Tìm kiếm học sinh</h3>

				<form action="FindStudentController" method="post" accept-charset="utf-8">
					<input type="text" name="name" placeholder="nhap ten hoc sinh...">
					<select name="dropdown_class">
						<c:forEach items="${listclass}" var="cl">
							<option value="${cl.classId}">${cl.className}</option>
						</c:forEach>
					</select> <input type="submit" name="submit" value="tìm kiếm">
				</form>

				<table>
					<tr>
						<c:forEach items="${listResult}" var="st">
							<td>${st.getstudentId}</td>
							<td>${st.getStudentName }</td>
							<td>${st.getmathPoint }</td>
							<td>${st.getPhysicPoint }</td>
							<td>${st.getChemPoint }</td>
							
						</c:forEach>

					</tr>

				</table>
			</div>
	
	</div>
	</div>


	<script src="assets/js/jquery-3.4.1.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="assets/js/app.js"></script>
</body>
</html>