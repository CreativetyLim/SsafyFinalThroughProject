<template>
    <div class="qna mt-4">
        <div class="input-group mb-3 float-right w-25">
            <input type="text" class="form-control" placeholder="어떤것이 궁금하세요??" aria-label="Recipient's username" aria-describedby="button-addon2">
            <div class="input-group-append">
                <button class="btn btn-outline-secondary" type="button" id="button-addon2">Button</button>
            </div>
        </div>
        <table class="table">
            <caption>QnA 보드 생성중..</caption>
            <thead>
                <tr>
                <th scope="col">#</th>
                <th scope="col">제목</th>
                <th scope="col">작성자</th>
                <th scope="col">작성일</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                <th scope="row">1</th>
                <td>위치 기반 프로그램 사용예시</td>
                <td>Otto</td>
                <td>@mdo</td>
                </tr>
                <tr>
                <th scope="row">2</th>
                <td>게시판을 만드는 예시를 제공</td>
                <td>Thornton</td>
                <td>@fat</td>
                </tr>
                <tr>
                <th scope="row">3</th>
                <td>자유게시판 이용방법 예시를</td>
                <td>the Bird</td>
                <td>@twitter</td>
                </tr>
            </tbody>
            </table>
    </div>
</template>

<script>
export default {
  name: 'QnABoard',
  props: {
    msg: String
  }
}
</script>