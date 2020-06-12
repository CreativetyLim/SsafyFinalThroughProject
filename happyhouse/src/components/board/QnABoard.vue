<template>
    <div class="qna mt-4">
        <div class="input-group mb-3 float-right w-25">
            <input type="text" class="form-control" placeholder="어떤것이 궁금하세요??" aria-label="Recipient's username" aria-describedby="button-addon2">
            <div class="input-group-append">
                <b-button @click="searchContent" >검색</b-button>
            </div>
        </div>
        <b-table
            striped
            hover
            :items="items"
            :per-page="perPage"
            :current-page="currentPage"
            :fields="fields"
            @row-clicked="rowClick"
        ></b-table>
        <b-pagination v-model="currentPage" :total-rows="rows" :per-page="perPage" align="center"></b-pagination>
        <b-button @click="writeContent">글쓰기</b-button>
    </div>
</template>

<script>
//import axios from 'axios'
import data from '@/data'
export default {
  name: 'QnABoard',
  data() {
  let contentItems = data.Content.sort((a, b) => {
      return b.content_id - a.content_id;
    }); // 내림차순

    // User 와 Content 의 user_id 의 같은 번호를 찾아 Content 에 기존자료 + 'user_name' 으로 추가한다.
    let items = contentItems.map(contentItem => {
      return {
        ...contentItem,
        user_name: data.User.filter(userItem => {
          return contentItem.user_id === userItem.user_id;
        })[0].name
      };
    });

    return {
      currentPage: 1, // 현재 페이지
      perPage: 10, // 페이지당 보여줄 갯수
      // bootstrap 'b-table' 필드 설정
      fields: [
        {
          key: "content_id",
          label: "번호"
        },
        {
          key: "title",
          label: "제목"
        },
        {
          key: "user_name",
          label: "글쓴이"
        },
        {
          key: "created_at",
          label: "작성일"
        }
      ],
      items: items
    };
  },
  methods: {
    rowClick(item) {
      this.$router.push({
        path: `/board/${item.content_id}`
      });
    },
    writeContent() {
      this.$router.push({
        path: `/BoardCreate`
      });
    }
  },
  computed: {
    rows() {
      return this.items.length;
    }
  }
};
//   data () {
//     return {
//       searchQuery: '',
//       qnaColumns: ['qna_no', 'qna_title', 'qna_userid', 'qna_datetime'],
//       qnaData:[]
//     }
//   },
//   created(){
//     this.load()
//   },
//   methods:{
//     load(){
//       axios.get('http://localhost:9999/happyhouse/qnaBoard')
//       .then(res => {
//         this.gridData = res.data;
//       }).catch(e => {
//         console.error(e)
//       })
//     }
//   }
// }
</script>
