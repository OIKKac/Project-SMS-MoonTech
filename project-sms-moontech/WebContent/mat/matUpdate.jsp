<jsp:include page="/include/header.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Page content -->
<div class="right-body">
	<div class="top-header">
		<div class="top-menu">
			<div class="breadcrumb">
				<a class="title-link" href="#/"> <span class="title-text">재료목록</span>
				</a>
			</div>
		</div>
	</div>
</div>
<div class="bottom-body">
	<div class="bottom-body-scroll body-render-wrapper">
		<div class="product-edit">
			<div class="left">
				<div class="mat-info">
					<div class="title">재료정보</div>
					<div class="header">
						<div class="button">
							<button class="btn mr-10">삭제</button>
						</div>
					</div>
				</div>
				<div class="padding">
					<div class="section-row">
						<div class="left-section">
							<div class="photo">
								<div style="cursor: pointer;">
									<input style="display: none" type="file" name="command"
										value="mat_update"
										accept="image/gif, image/jpg, image/jpeg,image/png, .gif, .jpg,.jpeg, .png/">
									<div class="commin-ui-photo-upload"
										style="line-height: 0; display: inline-block; position: relative;">
										<div class="for-printer-only"
											style="width: 100px; height: 100px;"
											src=" C:\WorkSapce\moon-sms\picture" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<form method="post" name="frm" action="mat.do">
	<div class="right-section">
		<div class="form-group">
			<div class="label">재료번호</div>
			<div class="control">
				<div class="control-group">
					<div class="number-input">
						<input type="text" placeholder="matSq" name="command"
							value= "${mat.matSq}" />
					</div>
				</div>
			</div>
		</div>
	</div>




	
		<div class="label">재료명</div>
		<div class="control">
			<div class="number-input">
				<input type="text" name="matNm"
					value="${mat.matNm}"  />
			</div>
		</div>

	
	<div class="label">재료크기</div>
		<div class="control">
			<div class="number-input">
				<input type="text" name="matSize"
					value="${mat.matSize}"  />
			</div>
		</div>
	
	<div class="label">무게</div>
		<div class="control">
			<div class="number-input">
				<input type="text" name="weight"
					value="${mat.Weight}"  />
			</div>
		</div>
	
	<div class="label">표준가격</div>
		<div class="control">
			<div class="number-input">
				<input type="text" name="stanPrice"
					value="${mat.stanPrice}"  />
			</div>
		</div>
	<input type="submit" value="수정" onclick="return emptyCheck()">
</form>

<!-- <div id="wrap" align="center">
		<h1>게시글 수정</h1>
		<form name="frm" method="post" action="BoardServlet">
			<input type="hidden" name="command" value="board_update"> <input
				type="hidden" name="num" value="${board.num}">
			<table>
				<tr>
					<th>작성자</th>
					<td><input type="text" size="12" name="name"
						value="${board.name}"> * 필수</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" size="12" name="pass"> *
						필수 (게시물 수정 삭제시 필요합니다.)</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" size="40" maxlength="50" name="email"
						value="${board.email}"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" size="70" name="title"
						value="${board.title}"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="70" rows="15" name="content">${board.content}</textarea></td>
				</tr>
			</table>
			<br>
			<br> <input type="submit" value="등록"
				onclick="return boardCheck()"> <input type="reset"
				value="다시 작성"> <input type="button" value="목록"
				onclick="location.href='BoardServlet?command=board_list'">
		</form>
	</div>
	 -->

</body>
</html>