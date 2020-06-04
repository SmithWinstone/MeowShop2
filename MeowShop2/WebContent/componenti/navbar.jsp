<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<%@page import="meowshop.bean.Carrello"%>
		<meta charset="utf-8">
		<title> MeowShop | Navigation Bar </title>  
		<meta name="description" content="Navigation Bar">
			
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		
		<!-- #CSS Links -->
		<!-- Basic Styles -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="css/font-awesome.min.css">

		<!-- SmartAdmin Styles : Caution! DO NOT change the order -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-production.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-skins.min.css">

		<!-- We recommend you use "your_style.css" to override SmartAdmin
		     specific styles this will also ensure you retrain your customization with each SmartAdmin update.
		<link rel="stylesheet" type="text/css" media="screen" href="css/your_style.css"> -->

		<!-- #FAVICONS -->
		<link rel="shortcut icon" href="img/logo3.png" type="image/x-icon">
		<link rel="icon" href="img/logo3.png" type="image/x-icon">

		<!-- #GOOGLE FONT -->
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">

		<!-- #APP SCREEN / ICONS -->
		<!-- Specifying a Webpage Icon for Web Clip 
			 Ref: https://developer.apple.com/library/ios/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html -->
		<link rel="apple-touch-icon" href="img/splash/sptouch-icon-iphone.png">
		<link rel="apple-touch-icon" sizes="76x76" href="img/splash/touch-icon-ipad.png">
		<link rel="apple-touch-icon" sizes="120x120" href="img/splash/touch-icon-iphone-retina.png">
		<link rel="apple-touch-icon" sizes="152x152" href="img/splash/touch-icon-ipad-retina.png">
		
		<!-- iOS web-app metas : hides Safari UI Components and Changes Status Bar Appearance -->
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		
		<!-- Startup image for web apps -->
		<link rel="apple-touch-startup-image" href="img/splash/ipad-landscape.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
		<link rel="apple-touch-startup-image" href="img/splash/ipad-portrait.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
		<link rel="apple-touch-startup-image" href="img/splash/iphone.png" media="screen and (max-device-width: 320px)">
	</head>
	
	<body>
	<!-- CREO CARRELLO SU CUI LAVORARE -->
	<!-- DOVREBBE ESSERE CHIAMATO SEMPRE AL PRIMO ACCESSO -->	
		<% 
		Carrello carrello;
		if (session.getAttribute("carrello")!=null) {
			carrello=(Carrello)session.getAttribute("carrello");
			System.out.println("Carrello esistente.");
		}else {
			System.out.println("Creazione carrello...");
			carrello=new Carrello();
			System.out.println("Carrello creato.");
			System.out.println("Aggiungo il carrello alla sessione...");
			session.setAttribute("carrello", carrello);
			System.out.println("Carrello aggiunto alla sessione.");
		}
		System.out.println("Dimensioni del carrello:"+ carrello.getLunghezzaCarrello());
		%>
	







	
	<!-- CONTROLLA LOGIN E DECIDE QUALE HEADER INCLUDERE -->
	<% if (session.getAttribute("email")!=null) { 
	      if(session.getAttribute("email").equals("admin@admin.it")){%>
			<%@ include file ="headerAmministratore.jsp"%>
		<%}else { %>
			<%@ include file = "header.jsp"%>
    	<%}
	} else { %>
		<%@	include file = "headerNoLog.jsp"%>
      <% } %>
		
		
		<!-- #NAVIGATION -->
		<!-- Left panel : Navigation area -->
		<!-- Note: This width of the aside area can be adjusted through LESS/SASS variables -->
		<aside id="left-panel">

			<!-- User info -->
			
								
					<!--  <div class="login-info">
					<a href="javascript:void(0);" id="show-shortcut" data-action="toggleShortcut">
<!-- 					Bisognerà inserire la seguente istruzione "utente.getFotoProfilo()" all'interno di dell'attributo src di img seguente 
						<img src="img/avatars/1.png" alt="foto profilo" class="online" />
						nome, cognome
					</a> 
				</span>
			</div> -->
			<!-- end user info -->

			<!-- NAVIGATION : This navigation is also responsive

			To make this navigation dynamic please make sure to link the node
			(the reference to the nav > ul) after page load. Or the navigation
			will not initialize.
			-->
			
			<nav>
			
				<!-- 
				NOTE: Notice the gaps after each icon usage <i></i>..
				Please note that these links work a bit different than
				traditional href="" links. See documentation for details.
				-->
				
				
				<ul>
					<li class="top-menu-invisible">
					
						<a href="#" title="Dashboard"><i class="fa fa-lg fa-fw fa fa-industry"></i> <span class="menu-item-parent">Categorie</span></a>
						<ul style="display: block;">
							<li class="top-menu-invisible">
							 
				  				<a href="${pageContext.request.contextPath}/mostraArticoli?categoria=Zona notte" title="Dashboard"><span class="menu-item-parent">Zona notte</span></a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/mostraArticoli?categoria=Svago"><span class="menu-item-parent">Svago</span></a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/mostraArticoli?categoria=Trasporto" title="Dashboard"><span class="menu-item-parent">Trasporto</span></a>
							</li>
						</ul>	
						
					</li>
					
					
				</ul>
				
				
				
				<!--  minorepercentuale //for x: listaprodotti %>
				<h1> {% x.getNome%}</h1>
				<p> 
				<a href="${pageContext.request.contextPath}/selezioneArticoli?articolo=1">Sport</a> -->
				 
				
				
				
				
				
			</nav>

			<span class="minifyme" data-action="minifyMenu"> <i class="fa fa-arrow-circle-left hit"></i> </span>

		</aside>
		<!-- END NAVIGATION -->
		
		<!-- #PLUGINS -->
		<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
		<script src="//ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script>
			if (!window.jQuery) {
				document.write('<script src="js/libs/jquery-3.2.1.min.js"><\/script>');
			}
		</script>

		<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
		<script>
			if (!window.jQuery.ui) {
				document.write('<script src="js/libs/jquery-ui.min.js"><\/script>');
			}
		</script>

		<!-- IMPORTANT: APP CONFIG -->
		<script src="js/app.config.js"></script>

		<!-- BOOTSTRAP JS -->
		<script src="js/bootstrap/bootstrap.min.js"></script>

		<!--[if IE 8]>
			<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
		<![endif]-->

		<!-- MAIN APP JS FILE -->
		<script src="js/app.min.js"></script>

		<!-- Your GOOGLE ANALYTICS CODE Below -->
		<script>
	
		  var _gaq = _gaq || [];
		  _gaq.push(['_setAccount', 'UA-XXXXXXXX-X']);
		  _gaq.push(['_trackPageview']);
		
		  (function() {
		    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
		    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
		    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
		  })();
		
		</script>
		
	</body>
</html>