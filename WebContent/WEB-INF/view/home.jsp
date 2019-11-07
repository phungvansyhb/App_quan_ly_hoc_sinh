<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title></title>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<link rel="stylesheet" type="text/css"	href="assets/font-awesome/css/font-awesome.min.css">
<style type="text/css">
  <%@include file="assets/css/style.css" %>
  <%@include file="assets/css/bootstrap.min.css" %>
</style>
</head>
<body>
	<div class="logo">Ứng Dụng quản lý học sinh</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
			
				<h3>Thêm học sinh</h3>

				<form action="AddstudentController" method="post"
					accept-charset="utf-8">
					Nhập tên :<input type="text" name="name" placeholder="nhap ten hoc sinh...">
					Nhập điểm:<input type="text" name="point" placeholder="nhap diem...">
					Chọn lớp:
					 <select name="dropdown_class">
						<c:forEach items="${listclass}" var="cl">
							<option value="${cl.classId}">${cl.className}</option>
						</c:forEach>
					</select> 
					<input type="submit" name="submit" value="thêm">
				</form>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
				<h3>Tìm kiếm học sinh</h3>

				<form action="FindStudentController" method="post"
					accept-charset="utf-8">
					Điền thông tin
					<input type="text" name="name" placeholder="nhap ten hoc sinh...">
					
					
					Chọn khối :
					<select name="dropdown_grade">
						<c:forEach items="${listgraduate}" var="grade">
							<option value="${grade.graduateId}">${grade.graduateName}</option>
						</c:forEach>
					</select>
					<select name="dropdown_class">
						<c:forEach items="${listclass}" var="cl">
							<option value="${cl.classId}">${cl.className}</option>
						</c:forEach>
					</select> 
					<input type="submit" name="submit" value="tìm lớp">
				</form>
			</div>
		</div>

	</div>

	</div>


	<script src="assets/js/jquery-3.4.1.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="assets/js/app.js"></script>
</body>
</html>