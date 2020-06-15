<template>
  <div>
    <b-navbar toggleable="lg" type="dark" variant="info">
      <b-navbar-brand to="/">Q&A 게시판</b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item to="/">Q&A</b-nav-item>
          <b-nav-item to="/Login">로그인</b-nav-item>
          <b-nav-item to="/SignUp">회원가입</b-nav-item>
          <b-nav-item to="/BoardTest">테스트 페이지</b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
export default {
  nama: "Header",
  data() {
    return {};
  }
};
</script>