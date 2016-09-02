<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


            <!DOCTYPE html>
            <html>

            <head>
                <title>사원등록</title>
                <meta charset="UTF-8">

                <!--페이지마다 복사  -->
                <meta name="viewport" content="width=device-width, initial-scale=1">
                <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
                <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

                <!-- 달력위한 것듯 -->
                <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
                <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
                <link rel="stylesheet" href="/resources/demos/style.css">
                <script>
                    $(function() {
                        $("#entrydt").datepicker({
                            dateFormat: 'yy-mm-dd',
                            changeMonth: true,
                            dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일',
                                '일요일'
                            ],
                            dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'],
                            monthNamesShort: ['1', '2', '3', '4', '5', '6', '7', '8',
                                '9', '10', '11', '12'
                            ],
                            monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월',
                                '8월', '9월', '10월', '11월', '12월'
                            ]

                        });
                        /* 이미지 미리보기*/
                        function readURL(input) {
                            if (input.files && input.files[0]) {
                                var reader = new FileReader(); //파일을 읽기 위한 FileReader객체 생성
                                reader.onload = function(e) {
                                    //파일 읽어들이기를 성공했을때 호출되는 이벤트 핸들러
                                    $('#pic_image').attr('src', e.target.result);
                                    //이미지 Tag의 SRC속성에 읽어들인 File내용을 지정
                                    //(아래 코드에서 읽어들인 dataURL형식)
                                }
                                reader.readAsDataURL(input.files[0]);
                                //File내용을 읽어 dataURL형식의 문자열로 저장
                            }
                        } //readURL()--

                        //file 양식으로 이미지를 선택(값이 변경) 되었을때 처리하는 코드
                        $("#pic_img").change(function() {
                            //alert(this.value); //선택한 이미지 경로 표시
                            readURL(this);
                        });

                    });
                </script>
                <!-- 달력 끝 -->
                <link href="../../css/view.css" rel="stylesheet" type="text/css">

            </head>

            <body>

                <div class="container-fluid text-center">
                    <%@ include file="../header.jsp"%>
                        <div class="row content">
                            <div class="col-sm-2 sidenav">
                                <p>
                                    <a href="#">Link</a>
                                </p>
                                <p>
                                    <a href="#">Link</a>
                                </p>
                                <p>
                                    <a href="#">Link</a>
                                </p>
                            </div>
                            <!-- 여기부터 contents -->
                            <div class="col-sm-8 text-left" style="overflow: auto; height: 750px">
                                <h1 class="text-center">사원 등록 페이지</h1>
                                <form action="StaffServlet?command=staff_write" method="post" enctype="multipart/form-data" name="frm">
                                    <input type="hidden" name="command" value="staff_write">
                                    <table class="table table-hober table-condensed">

                                        <tr>
                                            <td rowspan="14" class="col-sm-2"><img src="img/jquery.jpg" width="200em" height="200em" id="pic_image"> <br /> <br />
                                                <input type="file" name="pic_img" id="pic_img"></td>
                                            <th class="col-sm-2">사번</th>
                                            <td class="col-sm-8"><input type="text" name="stfid" value="${getstfid.stfid }"></td>
                                        </tr>
                                        <tr>
                                            <th>비밀번호</th>
                                            <td><input type="password" name="pwd"> &nbsp;비밀번호확인&nbsp;&nbsp;
                                                <input type="password"></td>
                                        </tr>
                                        <tr>
                                            <th>이름</th>
                                            <td><input type="text" name="stfnm"></td>
                                        </tr>
                                        <tr>
                                            <th>주민번호</th>
                                            <td><input type="text" name="jumin1">-<input type="text" name="jumin2"></td>
                                        </tr>
                                        <tr>
                                            <th>전화번호</th>
                                            <td><input type="text" name="phone"></td>
                                        </tr>
                                        <tr>
                                            <th>주소</th>
                                            <td><input type="text" name="address" id="address">
                                                <button type="button" class="btn btn-sm" data-toggle="modal" data-target="#myModal">주소 검색</button>
                                                <!-- Modal 시작 -->
                                                <div class="modal fade" id="myModal" role="dialog" >
                                                    <div class="modal-dialog">
                                                        <!-- Modal content-->
                                                        <div class="modal-content">
                                                            찾고자 하는 주소의 "동(읍/면/동)"을 입력하여 주세요. <br> 동이름 <input type="text" name="dong" id="dong"> <input type="button" value="확인" id="dongsubmit">
															<div style="overflow: auto; height: 400px">                                                            
                                                            <table id="dongtable" class="table">
                                                            </table>
                                                            </div>
                                                            <script>
                                                                $(function() {

                                                                    $("#dongsubmit").click(
                                                                        function(event) {
                                                                        	$(".aaa").remove();
                                                                            var dong = $("#dong");
                                                                            var inputData = new Object();
                                                                            inputData.dong = dong.val();

                                                                            if ($.trim(dong.val()) == "") {
                                                                                alert("동/읍/면을 입력하세요.");
                                                                                pName.focus();
                                                                                return;
                                                                            }
                                                                            $.ajax({
                                                                                url: "StaffServlet?command=zipcode_list",
                                                                                type: "post",
                                                                                data: inputData,
                                                                                dataType: "json",
                                                                                success: function(result) {
                                                                                    for (var index = 0; index < result.length; index++) {
                                                                                        var jsonObject = JSON.stringify(result[index]);
                                                                                        var json = JSON.parse(jsonObject);
                                                                                        var dongtext = "<tr class='aaa'>" +
                                                                                                "<td>" +
                                                                                                "("+json.zipcode + ")&nbsp;"+ json.sido +"&nbsp;"+ json.gugun +"&nbsp;"+ json.dong +"&nbsp;"+ json.ri +"&nbsp;"+ json.bldg +"&nbsp;"+ json.bungi 
                                                                                                 "</td>" +
                                                                                                "</tr>";	
                                                                                        $('#dongtable').append(dongtext);
                                                                                    }
                                                                                }
                                                                            });
                                                                                        $(document).on("click",".aaa",function() {
																							$("#address").val($(this).text());
																							$(".aaa").remove();
																							$('#myModal').modal('hide');
                                                                                        });
                                                                            $("#dong").val("");
                                                                        });
                                                                });
                                                            </script>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- 모달끝 -->
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>상세주소</th>
                                            <td><input type="text" name="add_detail"></td>
                                        </tr>
                                        <tr>
                                            <th>연봉</th>
                                            <td><input type="text" name="salary"></td>
                                        </tr>
                                        <tr>
                                            <th>부서</th>
                                            <td><select id="deptid" name="deptid">
									<option>부서 선택</option>
									<option value="1">총무</option>
									<option value="2">재경</option>
									<option value="3">인사</option>
									<option value="4">기술지원</option>
							</select></td>
                                        </tr>
                                        <tr>
                                            <th>직급</th>
                                            <td><select id="jobid" name="jobid">
									<option>직급 선택</option>
									<option value="1">인턴</option>
									<option value="2">사원</option>
									<option value="3">주임</option>
									<option value="4">대리</option>
									<option value="5">과장</option>
									<option value="6">차장</option>
									<option value="7">부장</option>
									<option value="8">상무</option>
									<option value="9">전무</option>
									<option value="10">부사장</option>
									<option value="11">사장</option>
							</select></td>
                                        </tr>
                                        <tr>
                                            <th>입사일</th>
                                            <td><input id="entrydt" name="entrydt" type="text">
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>관리자 여부</th>
                                            <td><input type="radio" name="ismgr" value="N" checked="checked"> 일반사원 <input type="radio" name="ismgr" value="Y"> 관리자</td>
                                        </tr>
                                    </table>
                                    <div style="text-align: center">
                                        <input type="submit" value="등록"> <input type="button" value="취소">
                                    </div>
                                    <h4>상세정보 입력</h4>
                                    <ul class="nav nav-tabs">
                                        <li class="active"><a data-toggle="tab" href="#home">학력사항</a></li>
                                        <li><a data-toggle="tab" href="#menu1">경력사항</a></li>
                                        <li><a data-toggle="tab" href="#menu2">자격증</a></li>
                                    </ul>

                                    <div class="tab-content">
                                        <div id="home" class="tab-pane fade in active">
                                            <table class="table table-hober table-condensed">
                                                <tr>
                                                    <th>학교명</th>
                                                    <th>입학일자</th>
                                                    <th>졸업일자</th>
                                                    <th>전공</th>
                                                    <th>졸업구분</th>
                                                    <th>성적</th>
                                                </tr>
                                            </table>
                                        </div>
                                        <div id="menu1" class="tab-pane fade">
                                            <table class="table table-hober table-condensed">
                                                <tr>
                                                    <th>직장명</th>
                                                    <th>입사일</th>
                                                    <th>퇴사일</th>
                                                    <th>최종직위</th>
                                                    <th>담당업무</th>
                                                    <th>월급여</th>
                                                </tr>
                                            </table>
                                        </div>
                                        <div id="menu2" class="tab-pane fade">
                                            <table class="table table-hober table-condensed">
                                                <tr>
                                                    <th>자격증명</th>
                                                    <th>자격증번호</th>
                                                    <th>취득일</th>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>

                                </form>

                            </div>
                            <!-- 여기까지 contents -->
                            <div class="col-sm-2 sidenav">
                                <div class="well">
                                    <p>채팅</p>
                                </div>
                                <div class="well">
                                    <p>ADS</p>
                                </div>
                            </div>
                        </div>
                        <footer class="container-fluid text-center">
                            <p>Footer Text</p>
                        </footer>
                </div>

            </body>

            </html>