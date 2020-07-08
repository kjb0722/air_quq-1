<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="container">
    <h1><a href="//webrtc.github.io/samples/" title="WebRTC samples homepage">WebRTC samples</a>
        <span>getUserMedia</span></h1>

    <video id="gum-local" autoplay playsinline></video>
    <button id="showVideo">Open camera</button>

    <div id="errorMsg"></div>

    <p class="warning"><strong>Warning:</strong> if you're not using headphones, pressing play will cause feedback.</p>

    <p>Display the video stream from <code>getUserMedia()</code> in a video element.</p>

    <p>The <code>MediaStream</code> object <code>stream</code> passed to the <code>getUserMedia()</code> callback is in
        global scope, so you can inspect it from the console.</p>

    <a href="https://github.com/webrtc/samples/tree/gh-pages/src/content/getusermedia/gum"
       title="View source for this page on GitHub" id="viewSource">View source on GitHub</a>
</div>

<script src="https://webrtc.github.io/adapter/adapter-latest.js"></script>
<script src="/resources/js/expOnline/expOnline.js"></script>

<script src="/resources/js/expOnline/ga.js"></script>

</body>
</html>