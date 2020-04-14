
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>在线考试网</title>
		<script type="text/javascript" src="easyui/jquery.min.js"></script>
		<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
		<link rel="stylesheet" type="text/css" href="easyui/themes/gray/easyui.css">
		<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
		<link rel="stylesheet" type="text/css" href="css/reset.css">
		<link rel="stylesheet" type="text/css" href="css/index.css">
		<link rel="stylesheet" href="css/button.css">
		<script src="js/modernizr.custom.js"></script>
		<script src="js/button.js"></script>
		<link href="https://fonts.googleapis.com/css?family=Press+Start+2P" rel="stylesheet">
		<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
		<script src="/follow.js" type="text/javascript"></script>
		<style type="text/css">
			body {
				overflow-x: hidden;
				overflow-y: hidden;
			}

			#menu {
				position: relative;
				z-index: 10;
			}

			a {
				color: #000000;
			}

			.title {
				font-size: 65px;
			}

			.content {
				text-align: center;
			}

			.text {
				font-size: 20px;
				position: relative;
				top: 60px;
			}

			::-webkit-scrollbar {
				width: 5px;
				height: 5px;
			}

			::-webkit-scrollbar-track {
				-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
				border-radius: 4px;
				background-color: #FFFFFF;
			}

			::-webkit-scrollbar-thumb {
				border-radius: 5px;
				-webkit-box-shadow: inset 0 0 3px rgba(0, 0, 0, .3);
				background-color: #000000;
			}
			pre {
			    font-family: "微软雅黑";
			    white-space: pre-wrap;
			    word-wrap: break-word;
			}
			.a>.p{
			width:100%;
			height:100px;
			
			background-color: #3d444c;
			text-align: center;
			padding-top:5px;
			color:white;
			position: fixed;
			bottom:0;
			}
			
			.neir>div:first-child{
			width:100%;
			height:50px;	
			display: flex;
			justify-content: center;
			align-items: center;
			border-bottom:2px solid black;
			padding:5px;
			font-size:40px;
			}
			.neir>div:last-child {
			width:100%;
			height:650px;
			padding-left:30px;
			overflow-y:auto;
			text-indent:2em;
			font-size:30px;
			}
			.page{
				width:100%;
				height:30px;
				
			}
			.page>a{
				color:red;
				margin-right: 30px;
			}
		</style>
	</head>
	<body class="easyui-layout" style="margin: 0px; padding: 0px;">
		<div data-options="region:'north',split:false" style="border: 0px;height:55px;<!-- overflow-x: hidden; overflow-y: hidden; -->">
			
		</div>
	
		<!-- 内容 -->
		<div data-options="region:'center',split:false" style='border: 0px;overflow-x:hidden;' class="a">
			<div class="neir" id="neir">
				<div>程序员考试大纲</div>
				<div>
		一、考试说明 <br/>
			1．考试要求： <br/>
			（1）掌握数制及其转换、数据的机内表示、算术和逻辑运算，以及相关的应用数学基础知识； <br/>
			（2）理解计算机的组成以及各主要部件的性能指标； <br/>
			（3）掌握操作系统、程序设计语言的基础知识； <br/>
			（4）熟练掌握计算机常用软件的基本操作； <br/>
			（5）熟练掌握基本数据结构和常用算法； <br/>
			（6）熟练掌握C程序设计语言，以及C++、Java、Visual Basic其中一种程序设计语言； <br/>
			（7）熟悉数据库、网络和多媒体的基础知识； <br/>
			（8）掌握软件工程的基础知识，了解软件过程基本知识、软件开发项目管理的常识； <br/>
			（9）了解常用信息技术标准、安全性，以及有关法律、法规的基本知识； <br/>
			（10）了解信息化、计算机应用的基础知识； <br/>
			（11）正确阅读和理解计算机领域的简单英文资料。 <br/>
			2．通过本考试的合格人员能根据软件开发项目管理和软件工程的要求，按照程序设计规格说明书编制并调试程序，写出程序的相应文档，产生符合标准规范的、实现设计要求的、能正确可靠运行的程序，具有助理工程师（或技术员）的实际工作能力和业务水平。<br/> 
			3．本考试设置的科目包括： <br/>
			（1）计算机硬软件基础知识，考试时间为150分钟，笔试； <br/>
			（2）程序设计，考试时间为150分钟，笔试。 <br/><br/><br/>
			二、考试范围 <br/>
			考试科目1：计算机硬软件基础知识 <br/><br/>
			
			1. 计算机科学基础 <br/>
			1.1 数制及其转换 <br/>
			二进制、十进制和十六进制等常用数制及其相互转换 <br/>
			1.2 数据的表示 <br/>
			数的表示（原码、反码、补码表示，整数和实数的机内表示方法，精度和溢出） <br/>
			非数值表示（字符和汉字的机内表示、声音和图像的机内表示） <br/>
			校验方法和校验码（奇偶校验码、海明校验码） <br/>
			1.3 算术运算和逻辑运算 <br/>
			计算机中二进制数的运算方法 <br/>
			逻辑代数的基本运算和逻辑表达式的化简 <br/>
			1.4 数学应用 <br/>
			常用数值计算（矩阵、方程的近似求解、插值） <br/>
			排列组合、应用统计（数据的统计分析） <br/>
			1.5 常用数据结构 <br/>
			数组（表态数组、动态数组）、线性表、链表（单向链表、双向链表、循环链表）、队列、栈、树（二叉树、查找树）、图的定义、存储和操作 <br/>
			1.6 常用算法 <br/>
			常用的排序算法、查找算法、数值计算、字符串处理、数据压缩算法、递归算法、图的相关算法 <br/>
			算法与数据结构的关系，算法效率，算法设计，算法描述（流程图、伪代码、决策表） <br/>
			2． 计算机系统基础知识 <br/>
			2.1 硬件基础知识 <br/>
			2.1.1 计算机系统的组成，硬件系统、软件系统及层次结构 <br/>
			2.1.2 计算机类型和特点 <br/>
			微机、工作站、服务器、大型计算机、巨型计算机 <br/>
			2.1.3 中央处理器CPU <br/>
			运算器和控制器的组成，常用的寄存器、指令系统、寻址方式、指令执行控制、处理机性能 <br/>
			2.1.4 主存和辅存 <br/>
			存储器系统 <br/>
			存储介质（半导体、硬盘、光盘、闪存、软盘、磁带等） <br/>
			主存储器的组成、性能及基本原理 <br/>
			Cache的概念、虚拟存储的概念 <br/>
			辅存设备的类型、特性、性能和容量计算 <br/>
			2.1.5 I/O接口、I/O设备和通信设备 <br/>
			I/O接口（总线、DMA、通道、SCSI、并行口、RS232C、USB、IEEE1394） <br/>
			I/O设备的类型和特性（键盘、鼠标、显示器、打印机、扫描仪、摄像头，以及各种辅存设备） <br/>
			I/O设备控制方式（中断控制、DMA） <br/>
			通信设备的类型和特性（Modem、集线器、交换机、中继器、路由器、网桥、网关）及其连接方法和连接介质（串行连接、并行连接，传输介质的类型和特性） <br/>
			2.2 软件基础知识 <br/>
			2.2.1 操作系统基础知识 <br/>
			操作系统的类型和功能 <br/>
			操作系统的内核（中断控制）和进程概念 <br/>
			处理机管理、存储管理、设备管理、文件管理、作业管理 <br/>
			汉字处理 <br/>
			图形用户界面及其操作方法 <br/>
			2.2.2 程序设计语言和语言处理程序基础知识 <br/>
			汇编、编译、解释系统的基础知识 <br/>
			程序设计语言的基本成分（数据、运算、控制和传输） <br/>
			过程（函数）调用 <br/>
			2.3 网络基础知识 <br/>
			网络的功能、分类、组成和拓扑结构 <br/>
			网络体系结构与协议（OSI/RM，TCP/IP） <br/>
			常用网络设备与网络通信设备，网络操作系统基础知识和使用 <br/>
			Client/Server结构、Browser/Server结构 <br/>
			LAN基础知识 <br/>
			Internet基础知识 <br/>
			2.4 数据库基础知识 <br/>
			数据库管理系统的主要功能和特征 <br/>
			数据库模型（概念模式、外模式、内模式） <br/>
			数据模型，ER图 <br/>
			数据操作（关系运算） <br/>
			数据库语言（SQL） <br/>
			数据库的主要控制功能 <br/>
			2.5 多媒体基础知识 <br/>
			多媒体基础概念，常用多媒体设备性能特征，常用多媒体文件格式类型 <br/>
			简单图形的绘制，图像文件的基本处理方法 <br/>
			音频和视频信息的应用 <br/>
			简单多媒体应用制作方法 <br/>
			2.6 系统性能指标 <br/>
			响应时间、吞吐量、周转时间等概念 <br/>
			可靠性、可维护性、可扩充性、可移植性、可用性、可重用性、安全性等概念 <br/>
			2.7 计算机应用基础知识和常用办公软件的操作方法 <br/>
			信息管理、数据处理、辅助设计、自动控制、科学计算、人工智能等概念 <br/>
			文字处理基础知识和常用操作方法 <br/>
			电子表格处理基础知识和常用操作方法 <br/>
			演示文稿制作方法 <br/>
			电子邮件处理操作方法 <br/>
			网页制作方法 <br/>
			3． 软件开发和运行维护基础知识 <br/>
			3.1 软件工程和项目管理基础知识 <br/>
			软件工程基本概念 <br/>
			软件开发各阶段的目标和任务 <br/>
			软件过程基本知识 <br/>
			软件工程项目管理基本知识 <br/>
			面向对象开发方法基础知识 <br/>
			软件开发工具与环境基础知识（CASE） <br/>
			软件质量管理基础知识 <br/>
			3.2 软件需求分析、需求定义及软件基础知识 <br/>
			结构化分析概念（数据流图（DFD）、实体关系图（ER）） <br/>
			面向对象设计、结构化设计基础知识 <br/>
			模拟设计、代码设计、人机界面设计要点 <br/>
			3.3 程序设计基础知识 <br/>
			结构设计程序设计，程序流程图，NS图，PAD图 <br/>
			程序设计风格 <br/>
			面向对象设计基础知识、可视化程序设计基础知识 <br/>
			3.4 程序测试基础知识 <br/>
			黑盒测试、白盒测试、灰盒测试基础知识 <br/>
			测试工作流程 <br/>
			3.5 软件开发文档基础知识 <br/>
			3.6 软件运行和维护基础知识 <br/>
			软件运行基础知识 <br/>
			软件维护基础知识 <br/>
			4． 安全性基础知识 <br/>
			安全性基本概念 <br/>
			计算机病毒的防治，计算机犯罪的防范 <br/>
			访问控制 <br/>
			加密与解密基础知识<br/> 
			5． 标准化基础知识 <br/>
			标准化基本概念 <br/>
			国际标准、国家标准、行业标准、企业标准基础知识 <br/>
			代码标准、文件格式标准、安全标准、软件开发规范和文档标准基础知识 <br/>
			标准化机构 <br/>
			6． 信息化基本知识 <br/>
			信息化基本概念 <br/>
			全球信息化趋势，国家信息化战略，企业信息化战略和策略常识 <br/>
			有关的法律、法规要点 <br/>
			过程教育、电子商务、电子政务等常识 <br/>
			企业信息资源管理常识 <br/>
			7． 计算机专业英语 <br/>
			掌握计算机技术的基本词汇 <br/>
			能正确阅读和理解本领域的简单英文资料 <br/><br/>
			
			考试科目2：程序设计 <br/>
			1. 内部设计 <br/>
			1.1 理解外部设计 <br/>
			1.2 功能划分和确定结构 <br/>
			数据流图、结构图 <br/>
			1.3 物理数据设计 <br/>
			确定数据组织方式、存储介质，设计记录格式和处理方式 <br/>
			1.4 详细输入输出设计 <br/>
			界面设计、报表设计 <br/>
			1.5 内部设计文档 <br/>
			对程序接口、程序功能、人机界面、输入输出、测试计划的描述 <br/>
			1.6 内部设计文档 <br/>
			2． 程序设计 <br/>
			2.1 模拟划分（原则、方法、标准） <br/>
			2.2 编写程序设计文档 <br/>
			模块规格说明书（程序处理逻辑的描述、输入输出数据格式的描述） <br/>
			测试要求说明书（测试类型和目标、测试用例、测试方法） <br/>
			2.3 程序设计评审 <br/>
			3． 程序实现 <br/>
			3.1 编程 <br/>
			编程方法和标准 <br/>
			程序设计语言的使用 <br/>
			人工检查 <br/>
			程序文档化 <br/>
			3.2 程序测试 <br/>
			准备测试环境和测试工具 <br/>
			准备测试数据 <br/>
			写出测试报告 <br/>
			4.程序设计语言（C语言为必选，其他语言可以任选一种） <br/>
			4.1 C程序设计语言（ANSI C标准） <br/>
			程序结构，语法，数据类型说明，可执行语句，函数调用，标准库函数，指针 <br/>
			4.2 C＋＋程序设计语言（ANSI C＋＋标准） <br/>
			C＋＋和面向对象程序设计，语法和程序结构，类、成员、构造函数、析构函数、模板、继承、多态 <br/>
			4.3 Java程序设计（Java 2） <br/>
			Java和面向对象程序设计 <br/>
			语言机制（程序结构和语法，类、成员、构造函数、析构函数、继承、接口） <br/>
			4.4 Visual Basic程序设计（Visual Basic 6.0） <br/>
			用户界面设计 <br/>
			程序结构和语法 <br/>
			文件系统对象 <br/>
			访问数据库<br/>
				<pre>
				
				</pre></div>
			</div>
			<div class="page">
			</div>
			  <div class="p">
			 版权所有:智能时代18合一第一组   © 2020-2099  All Rights Reserved<br><br>
			删帖入口     鄂ICP备13012778号-1<br><br>
			健康人生 学习<br>
			  </div>
			 
		</div>
		
		<script type="text/javascript">

		function load(name) {
		    let xhr = new XMLHttpRequest(),
		        okStatus = document.location.protocol === "file:" ? 0 : 200;
		    xhr.open('GET', name, false);
		    xhr.overrideMimeType("text/html;charset=utf-8");//默认为utf-8
		    xhr.send(null);
		    return xhr.status === okStatus ? xhr.responseText : null;
		}
		 
		let text = load("test.txt");
		console.log(text);
		</script>



		<!-- 顶部菜单 -->
	<div id="menu">
		<div class="index-nav">
			<div class="index-nav-frame clearfix">
				<div class="nav-line"></div>
				<div class="nav-small" tabindex="-1">
					<div class="nav-small-focus" tabindex="-1"></div>
					<img src="img/icon.png">
				</div>
				<div class="index-nav-frame-line active" tabindex="-1"
					style="position: absolute; left: 0px; bottom: 5px;">
					<img src="img/logo.png" onclick="index()">
				</div>
				<div class="index-nav-frame-line active" tabindex="-1">
					<a href="javascript:;" onclick="index()">首页</a>
					<div class="index-nav-frame-line-center">
						<div class="index-nav-frame-line-li">
							<a href="http://localhost:8080/TestOnline/#tr1">欢迎页</a>
						</div>
						<div class="index-nav-frame-line-li">
							<a href="http://localhost:8080/TestOnline/#tr2">项目介绍</a>
						</div>
						<div class="index-nav-frame-line-li">
							<a href="http://localhost:8080/TestOnline/#tr3">关于</a>
						</div>
					</div>
					<div class="index-nav-frame-line-focus" tabindex="-1"></div>
				</div>
				<div class="index-nav-frame-line" tabindex="-1">
					学习
					<div class="index-nav-frame-line-center">
						<div class="index-nav-frame-line-li">
							<a href="studyArea.action">资料</a>
						</div>
						<div class="index-nav-frame-line-li">
							<a href="itemBank.action">题库</a>
						</div>
					</div>
					<div class="index-nav-frame-line-focus" tabindex="-1"></div>
				</div>
				<div class="index-nav-frame-line" tabindex="-1">
					考试
					<div class="index-nav-frame-line-center">
						<div class="index-nav-frame-line-li">
							<a href="testOnline.action">在线考试</a>
						</div>
						<div class="index-nav-frame-line-li">
							<a href="examinationRecord.action">考试记录</a>
						</div>
						<div class="index-nav-frame-line-li">
							<a href="examinationRank.action">考试排名</a>
						</div>
					</div>
					<div class="index-nav-frame-line-focus" tabindex="-1"></div>
				</div>
				<div class="index-nav-frame-line" tabindex="-1">
					新闻
					<div class="index-nav-frame-line-center">
						<div class="index-nav-frame-line-li">
							<a href="announcement.action">网站公告</a>
						</div>
						<div class="index-nav-frame-line-li">
							<a href="examNrom.jsp">考试大纲</a>
						</div>
					</div>
					<div class="index-nav-frame-line-focus" tabindex="-1"></div>
				</div>
				<div class="index-nav-frame-line" tabindex="-1"
					style="position: absolute; right: 60px; top: 0px;">
					<span id="uname">请先登陆</span>
					<div class="index-nav-frame-line-center" id="usermanager">
						<div class="index-nav-frame-line-li">
							<a href="javascript:;" id="userInfo" onclick="userInfo()">个人主页</a>
						</div>
						<div class="index-nav-frame-line-li" id="admin"
							style="display: none;">
							<a href="admin.action;" id="admin">后台管理</a>
						</div>
						<div class="index-nav-frame-line-li">
							<a href="javascript:;" onclick="outLogin()">退出登陆</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
		<div id="outLogin_infor" style="display: none;">退出登陆成功！</div>
	</body>
</html>
</div>
<div data-options="region:'center',split:false" style="border: 0px; overflow: hidden;"></div>
</body>
<script type="application/javascript">
	$(function() {
		var screeheight = $(window).height();
		var screewidth = $(window).width();
		// console.log(screeheight + "/" + screewidth + "/");
		$("#tb1").width(screewidth);
		$("#tr1").height(screeheight);
		$("#tr2").height(screeheight);
		$("#tr3").height(screeheight);
		$("#tb2").width(screewidth);
	})

	function userInfo() {
		$("#tb1").css("display", "none");
		$("#tb2").css("display", "block");
	}

	function index() {
		window.location.reload();
	}

	function goToLogin() {
		window.location.href = "login.action";
	}

	function outLogin() {
		$.ajax({
			type: "post",
			data: "outLogin",
			url: "user/out",
			success: function(result) {
				alert("退出登陆成功！");
				index();
			}
		})
	}

	var uname = '${user.uname}';
	var rname = '${user.rname}';

	if (uname == undefined || uname == null || uname == "") {
		$("#usermanager").css("display", "none");
		$("#uname").attr("onclick", "goToLogin()");
	} else {
		$("#uname").attr("onclick", "");
		$("#uname").text(uname);
		console.log('${user}');
		if (rname == "管理员") {
			$("#admin").css("display", "block");
		}
	}
</script>
</html>
