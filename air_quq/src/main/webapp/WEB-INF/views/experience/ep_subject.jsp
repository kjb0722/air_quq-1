<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="ep" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="h3 mb-4 text-gray-800">주요 주제 선택</h1>
<br>

<ep:if test="${sub=='subject' }">
	<h1>${category }</h1>
	<br>
	<ep:forEach var="i" items="${list}">

		<a
			href="/experince/ep_insert/Sub?num=${i.expernum }&name=${i.subname}"
			class="btn border-left-danger btn-icon-split"
			style="width: 30%; height: 70px; margin: 15px;"><div
				class="ep_sub_div"><p style="font-size: 30px; font-weight: bold; color: black;">${i.subname}<p></div></a>

	</ep:forEach>
</ep:if>

<ep:if test="${sub=='detailsub' }">
	<a href="/experience/ep_insert/type"><h1>${category }에는
			무엇이 포함되나요?</h1></a>
	<br>
	<ep:forEach var="i" items="${list}">

		<a href="/experience/ep_insert/subdetail?value=${i.subname}&num=${i.expernum}" class="btn border-left-danger btn-icon-split"
			style="width: 30%; height: 70px; margin: 15px;"><div
				class="ep_sub_div"><p style="font-size: 30px; font-weight: bold;color: black;">${i.subname}<p></div></a>

	</ep:forEach>
</ep:if>

<div class="ep_sub_btn"></div>


