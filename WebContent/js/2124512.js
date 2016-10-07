	function gradeChange(a) {
		if (a == 1) {
			document.getElementById("searchContext").setAttribute(
					"placeholder", "输入主播YY号,例如：504525");
			document.getElementById("searchtype").value = "YY";	
		} else if (a == 2) {
			document.getElementById("searchContext").setAttribute(
					"placeholder", "输入视频ID,例如：733592");
			document.getElementById("searchtype").value = "51AVI";
		} else if (a == 3) {
			document.getElementById("searchContext").setAttribute(
					"placeholder", "输入MVID,例如：833120");
			document.getElementById("searchtype").value = "YINYUETAI";
		} else {
			document.getElementById("searchContext").setAttribute(
					"placeholder", "输入视频ID,例如：b&b389");
			document.getElementById("searchtype").value = "LIAN";
		}
	}
	var result;
	function show() {
		var random_bg = parseInt(Math.random() * 66);
		var bg = 'url(images/bg-' + random_bg + '.jpg)';
		$("body").css("background-image", bg);
		//load(0);
		getjs();
	}
	function getjs(){  
        var name=encode64(document.getElementById("searchContext").value);
        var type=encode64(document.getElementById("searchtype").value);
        	$.ajax({   
                type:"POST", //请求方式  
                url:"result.jsp", //请求路径  
                cache: false,
                data:"searchContext=" + name + "&searchtype=" + type,  //传参  
                dataType: 'json',   //返回值类型  
               success:function(msg){          
            	   result=msg;
            	   if(document.getElementById("searchtype").value=="YY"){
            		   load(0); 
            	   }else{
//            		   var a=msg[0].hdVideoUrl;
//            		   var b=msg[0].hdVideoUrl;
//            		   var c=msg[0].hdVideoUrl;
            		   //alert(msg[0].title);
            		   //window.open("yinyuePlayer.jsp?a="+a+"&b="+b+"&c="+c);
            		   //YINload();
            	   }
            	 	
             	  
                   },  
                error:function(){  
             	   Showbo.Msg.alert("啊哦，出错了！！请稍后再试！");  
                }  
                });
          
     }
    // base64加密开始  
    var keyStr = "ABCDEFGHIJKLMNOP" + "QRSTUVWXYZabcdef" + "ghijklmnopqrstuv"  
            + "wxyz0123456789+/" + "=";  
      
    function encode64(input) {  
  
        var output = "";  
        var chr1, chr2, chr3 = "";  
        var enc1, enc2, enc3, enc4 = "";  
        var i = 0;  
        do {  
            chr1 = input.charCodeAt(i++);  
            chr2 = input.charCodeAt(i++);  
            chr3 = input.charCodeAt(i++);  
            enc1 = chr1 >> 2;  
            enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);  
            enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);  
            enc4 = chr3 & 63;  
            if (isNaN(chr2)) {  
                enc3 = enc4 = 64;  
            } else if (isNaN(chr3)) {  
                enc4 = 64;  
            }  
            output = output + keyStr.charAt(enc1) + keyStr.charAt(enc2)  
                    + keyStr.charAt(enc3) + keyStr.charAt(enc4);  
            chr1 = chr2 = chr3 = "";  
            enc1 = enc2 = enc3 = enc4 = "";  
        } while (i < input.length);  
  
        return output;  
    }
 	function load(p){
		var rst = result;
		if(p<0){
			Showbo.Msg.alert('已经是第一页了哦！');
		}else if(p>=rst.length){
			Showbo.Msg.alert("已经是最后一页了哦！");
		}else{
		var tbody = $("#video-model").find("ul");
		tbody.empty();
		for(var i=0;i<rst[p].song_list.length;i++){
			tbody.append(
					"<li class='video-user-item'><a class='video-user-box' href='"
					+"javascript:void(0)' onclick=subgo('"+rst[p].song_list[i].song_title.replace(" ","-")+"','"+rst[p].song_list[i].resurl+"','"+rst[p].song_list[i].pic+"')><div class='video-user-pic'><div class='video-pic'><div class='video-pic-inner'><div class='pic-default1'><img src='"
					+rst[p].song_list[i].pic+"' alt=&quot&quot/></div></div><div class='op-time'>"
					+rst[p].song_list[i].duration+"</div><div class='mask'></div><i class='icon-play'></i></div></div><div class='video-user-info'><p class='user-i-title'>"
					+rst[p].song_list[i].song_title+"</p><p class='user-video-op'><span class='op-like'><i class='icon-user-like'></i>"
					+rst[p].song_list[i].likeCount+"</span><span class='aud-count'><i class='icon-eye'></i>"
					+rst[p].song_list[i].watchCount+"</span></p></div></a></li>");
		}
		$("#cse2").remove();
		var inse = "";
		var sumpage = rst.length;
		if(sumpage > 3){
			for(var i=0;i<3;i++){
				inse = inse+"<li><a href='javascript:load("+i+")'>第"+(i+1)+"页</a></li>";
		
			}	
		}else{
			for(var i=0;i<sumpage;i++){
					inse = inse+"<li><a href='javascript:load("+i+")'>第"+(i+1)+"页</a></li>";
			
			}
		}
		inse = "<li><a value='1' href='javascript:load(0)'>首页</a></li><li><a href='javascript:load("+(p-1)+")'>上一页</a></li>"+inse+"<li><a href='javascript:load("+(p+1)+")'>下一页</a></li><li><a href='javascript:load("+(sumpage-1)+")'>尾页</a></li><li><i>当前第"+(p+1)+"页/共"+sumpage+"页</i></li>";
		$("#paed").find("ul").children().remove();
		$(document).ready(function(){
			$("#paed").find("ul").append(inse);
		});
		$("#paed").show();
		}
	}

 	function subgo(a,b,c){
 		var url="name="+a; 
 		url=encodeURI(encodeURI(url));
        window.open("webPlayer.jsp?"+url+"&url="+b+"&img="+c);
        	
 		
 	}
 	function YINload(){
 		//alert(result[0].hdVideoUrl);
 		var flashvars={
 				f:result[0].heVideoUrl,
 				a:'',
 				s:'0',
 				c:'0',
 				x:'',
 				i:'',
 				e:'3',
 				v:'50',
 				p:'0',
 				h:'3',
 				wh:'4:3',
 				lv:'0',
 				Title:result[0].hdVideoUrl,
 				deft:'流畅432P,高清540P,超清720P',
 				deff:result[0].hcVideoUrl|result[0].hdVideoUrl|result[0].heVideoUrl,
 				loaded:'loadedHandler'
 				};
 			var params={bgcolor:'#FFF',allowFullScreen:true,allowScriptAccess:'always'};
 			var video=['result[0].hdVideoUrl->video/mp4'];
 			CKobject.embed('ckplayer/ckplayer.swf','a1','ckplayer_a1','100%','100%',false,flashvars,video,params);
 	}
 	function loadedHandler(){
		if(CKobject.getObjectById('ckplayer_a1').getType()){//说明使用html5播放器
			document.title="正在播放:"+flashvars.Title;
			alert(flashvars.deft);
		}
		else{
			document.title="正在播放:"+flashvars.Title;
		}
	}