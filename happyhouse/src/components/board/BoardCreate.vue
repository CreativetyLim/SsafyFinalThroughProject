<template>
  <div class="mt-4">
    <div class="form-group">
      <label for="qna_userid">작성자</label>
      <input
        type="text"
        class="form-control"
        id="qna_userid"
        ref="qna_userid"
        placeholder="작성자를 입력하세요"
        v-model="qna_userid"
      />
    </div>
    <div class="form-group">
      <label for="qna_title">제목</label>
      <input
        type="text"
        class="form-control"
        id="qna_title"
        ref="qna_title"
        placeholder="제목을 입력하세요"
        v-model="qna_title"
      />
    </div>
    <div class="form-group">
      <label for="qna_content">내용</label>
      <textarea
        type="text"
        class="form-control"
        id="qna_content"
        ref="qna_content"
        placeholder="내용을 입력하세요"
        v-model="qna_content"
      ></textarea>
    </div>
    <div class="text-right">
      <button
        class="btn btn-primary"
        v-if="type == 'create'"
        @click="checkHandler">
        등록
      </button>
    </div>
    <div class="text-right">
      <b-btn @click="checkHandler">글 등록</b-btn>
    </div>
  </div>
</template>

<script>
import http from '@/util/http-common';
export default {
  name: 'BoardCreate',
  props: {
    type: { type: String },
  },
  data: function() {
    return {
      qnaNo: '',
      qnaDatetime: '',
      qnaUserid: '',
      qnaTitle: '',
      qnaContent: '',
    };
  },
  methods: {
    checkHandler() {
      let err = true;
      let msg = '';
      !this.qna_userid &&
        ((msg = '작성자를 입력해주세요'),
        (err = false),
        this.$refs.qna_userid.focus());
      err &&
        !this.qna_title &&
        ((msg = '제목 입력해주세요'), (err = false), this.$refs.qna_title.focus());
      err &&
        !this.qna_content &&
        ((msg = '내용 입력해주세요'),
        (err = false),
        this.$refs.qna_content.focus());

      if (!err) alert(msg);
      else this.type == 'create' ? this.createHandler() : this.updateHandler();
    },
    createHandler() {
      http
        .post('/board', {
          qna_userid: this.qna_userid,
          qna_title: this.qna_title,
          qna_content: this.qna_content,
        })
        .then(({ data }) => {
          let msg = '등록 처리시 문제가 발생했습니다.';
          if (data === 'success') {
            msg = '등록이 완료되었습니다.';
          }
          alert(msg);
          this.moveList();
        })
        .catch(() => {
          alert('등록 처리시 에러가 발생했습니다.');
        });
    },
    updateHandler() {
      http
        .put(`/board/${this.qna_no}`, {
          qna_no: this.qna_no,
          qna_datetime: this.qna_datetime,
          qna_userid: this.qna_userid,
          qna_title: this.qna_title,
          qna_content: this.qna_content,
        })
        .then(({ data }) => {
          let msg = '수정 처리시 문제가 발생했습니다.';
          if (data === 'success') {
            msg = '수정이 완료되었습니다.';
          }
          alert(msg);
          this.moveList();
        })
        .catch(() => {
          alert('수정 처리시 에러가 발생했습니다.');
        });
    },
    moveList() {
      this.$router.push('/QnABoard');
    },
  },
  created() {
    if (this.type === 'update') {
      http
        .get(`/board/${this.$route.query.qna_no}`)
        .then(({ data }) => {
          this.qna_no = data.qna_no;
          this.qna_datetime = data.qna_datetime;
          this.qna_userid = data.qna_userid;
          this.qna_title = data.qna_title;
          this.qna_content = data.qna_content;
        })
        .catch(() => {
          alert('에러가 발생했습니다.');
        });
    }
  },
};
</script>

<style scoped></style>
