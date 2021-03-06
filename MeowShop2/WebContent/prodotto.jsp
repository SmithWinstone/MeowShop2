<%@page import="java.util.ArrayList"%>
<%@page import="meowshop.bean.ProdottoBean"%>
<%@page import="javax.xml.ws.Dispatch"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title> MeowShop - Prodotti</title>
		<meta name="description" content="Prodotti">
			
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<!-- Basic Styles -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="css/font-awesome.min.css">

		<!-- SmartAdmin Styles : Caution! DO NOT change the order -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-production-plugins.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-production.min.css">
		<!--  <link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-skins.min.css"> -->

		<!-- SmartAdmin RTL Support -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-rtl.min.css"> 

		<!-- We recommend you use "your_style.css" to override SmartAdmin
		     specific styles   this will also ensure you retrain your customization with each SmartAdmin update.
		<link rel="stylesheet" type="text/css" media="screen" href="css/your_style.css"> -->

		<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/demo.min.css">

		<!-- FAVICONS -->
		<link rel="shortcut icon" href="img/logo3.png" type="image/x-icon">
		<link rel="icon" href="img/logo2.png" type="image/x-icon">

		<!-- GOOGLE FONT -->
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">

		<!-- Specifying a Webpage Icon for Web Clip 
			 Ref: https://developer.apple.com/library/ios/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html -->
		<link rel="apple-touch-icon" href="img/splash/sptouch-icon-iphone.png">
		<link rel="apple-touch-icon" sizes="76x76" href="img/splash/touch-icon-ipad.png">
		<link rel="apple-touch-icon" sizes="120x120" href="img/splash/touch-icon-iphone-retina.png">
		<link rel="apple-touch-icon" sizes="152x152" href="img/splash/touch-icon-ipad-retina.png">


		<link rel="stylesheet" type="text/css" media="screen" href="css/productCard.css">
		<link rel="stylesheet" type="text/css" media="screen" href="css/threeCol.css">
	</head>

	<body>

		<%@
			include file = "componenti/navbar.jsp"
		%>
		
		<!-- MAIN PANEL -->
		<div id="main" role="main">

			<!-- RIBBON -->
			<div id="ribbon">
				
				<!-- breadcrumb -->
				<ol class="breadcrumb">
					<li>MeowShop: Il posto ideale per trovare tanti articoli per i nostri amici a quattro zampe!</li>
				</ol>

			</div>
			<!-- END RIBBON -->




			<!--  corpo -->
			
			<% 
			ArrayList<ProdottoBean> lista_prodotti = (ArrayList<ProdottoBean>)request.getAttribute("prodotti");
			String categoria = (String)request.getAttribute("categoria");
			%>
			<h1> Categoria selezionata: <%= categoria %></h1>
			
		<% 	if(lista_prodotti.size() > 0){ 
				for(ProdottoBean prodotto: lista_prodotti){
			%>
			<% String foto = "img/"+prodotto.getFoto();
			System.out.println(foto);
			%>
			<form action="AggiungiCarrello" method="post">
				<div class="column">
  					<div class="card">
		 				<img src="<%=foto %>" alt="<%=prodotto.getNome() %>" width="200" height="300">
		 				<h1><%= prodotto.getNome() %></h1>
		  				<p class="price"><%= prodotto.getPrezzo() %></p>
		  				<p><%= prodotto.getDescrizione() %></p>
		  				<input type="hidden" id="itemID" name="itemID" value="<%=prodotto.getId()%>">
		  				<p><button>Aggiungi al carrello</button></p>
					</div>
  				</div>
  			</form>
			<%	
				}
			}else{ 
			%>
				<h1>Nessun prodotto attualmente disponibile per la categoria <%= categoria %></h1>
			<% 
			}
			%>
			
			
		
			</div>
			
			
			
		<!-- PAGE FOOTER %@ include file = "footer.jsp"%>-->
		<!-- END PAGE FOOTER -->

		<!--================================================== -->

		<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
		<script data-pace-options='{ "restartOnRequestAfter": true }' src="js/plugin/pace/pace.min.js"></script>

		<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
		
		<!-- JS TOUCH : include this plugin for mobile drag / drop touch events-->
		<script src="js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script> 

		<!-- CUSTOM NOTIFICATION -->
		<script src="js/notification/SmartNotification.min.js"></script>

		<!-- JARVIS WIDGETS -->
		<script src="js/smartwidgets/jarvis.widget.min.js"></script>

		<!-- EASY PIE CHARTS -->
		<script src="js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js"></script>

		<!-- SPARKLINES -->
		<script src="js/plugin/sparkline/jquery.sparkline.min.js"></script>

		<!-- JQUERY VALIDATE -->
		<script src="js/plugin/jquery-validate/jquery.validate.min.js"></script>

		<!-- JQUERY MASKED INPUT -->
		<script src="js/plugin/masked-input/jquery.maskedinput.min.js"></script>

		<!-- JQUERY SELECT2 INPUT -->
		<script src="js/plugin/select2/select2.min.js"></script>

		<!-- JQUERY UI + Bootstrap Slider -->
		<script src="js/plugin/bootstrap-slider/bootstrap-slider.min.js"></script>

		<!-- browser msie issue fix -->
		<script src="js/plugin/msie-fix/jquery.mb.browser.min.js"></script>

		<!-- FastClick: For mobile devices -->
		<script src="js/plugin/fastclick/fastclick.min.js"></script>

		<!--[if IE 8]>

		<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>

		<![endif]-->
		
		<!-- ENHANCEMENT PLUGINS : NOT A REQUIREMENT -->
		<!-- Voice command : plugin -->
		<script src="js/speech/voicecommand.min.js"></script>

		<!-- SmartChat UI : plugin -->
		<script src="js/smart-chat-ui/smart.chat.ui.min.js"></script>
		<script src="js/smart-chat-ui/smart.chat.manager.min.js"></script>

		<!-- PAGE RELATED PLUGIN(S) 
		<script src="..."></script>-->

		<script>
		
		// DO NOT REMOVE : GLOBAL FUNCTIONS!
		
		$(document).ready(function() {
			
			pageSetUp();
		
		})

		</script>

	</body>
</html>