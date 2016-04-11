<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />   
<c:set var="createGameUrl" value="/createGame" />  
<c:set var="gameRegister" value="/gameRegister" />  
<c:set var="customersRegister" value="/customersRegister" />
<c:set var="registration" value="/registration" />
<c:set var="logout" value="/logout" />
<c:set var="logout" value="/login" />
<c:set var="editOwnGame" value="/editOwnGame" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/style/font-awesome.css" />" >
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/style/colorPresets.css"/>">
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/style/styles.css"/>">

<script type="text/javascript" src="<c:url value="/resources/script/libs/jquery-1.12.3.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/script/libs/requester.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/script/ajaxRequest/workWithDB.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/script/script.js"/>"></script>
<title>Insert title here</title>
</head>
<body>
	<header>
	  <section class="stripe sansSerif whiteBG">
	    <div class="content padding20 relative">
	      <div class="topStripeIconGroup">
	        <a href="https://www.facebook.com/groups/672511086212718/" target="_blank">
	          <span class="topStripeIcon"><span class="fa fa-facebook"></span></span>
	        </a>
	
	        <span class="topStripeIcon"><span class="fa fa-search"></span></span>
	
	      </div>
	      <div class="logo"><span class="robotoSlab">Game</span> <span class="prCol">Night</span></div>
	    </div>
	  </section>
	
	  <section class="stripe sansSerif blackBG">
	    <div class="content">
	      <ul class="menu">
	        <li><a class="prColBGHover" href="${contextPath}/">Начало</a></li>
	        <li><a class="prColBGHover" href="${contextPath}${gameRegister}">Игри</a></li>
	        <li><a class="prColBGHover" id="createGame" href="${contextPath}${createGameUrl}">Създай игра</a></li>
	        
	        <!-- следващите 2 линка се скриват след "Вход" -->
	        <li class="right"><a class="prColBGHover" id="login" href="${contextPath}${login}">Вход</a></li>
	        <li class="right"><a class="prColBGHover" id="logout" href="${contextPath}${logout}">Изход</a></li>
	        <li class="right"><a class="prColBGHover" id="registration" href="${contextPath}${registration}">Регистрация</a></li>
	        
	        <!-- следващия линк ще се вижда след "Вход" -->
	        <li class="right"><a class="prColBGHover" id="prifile" href="${contextPath}/profile">Профил</a></li>
	        
	        <li><a class="prColBGHover" id="ownGames" href="${contextPath}${editOwnGame}">Създадени от теб игри</a></li>
	        <li><a class="prColBGHover" href="${contextPath}${customersRegister}">Потребители</a></li>
	      </ul>
	    </div>
	  </section>
	</header>