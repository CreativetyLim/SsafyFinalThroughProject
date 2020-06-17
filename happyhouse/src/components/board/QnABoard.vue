<template>
    <div class="qna mt-4">
        <div>
          <b-carousel
            id="carousel-1"
            v-model="slide"
            :interval="4000"
            controls
            indicators
            background="#ababab"
            img-width="1024"
            img-height="480"
            style="text-shadow: 1px 1px 2px #333;"
            @sliding-start="onSlideStart"
            @sliding-end="onSlideEnd"
          >
            <!-- Text slides with image -->
            <b-carousel-slide
              caption="HappyHouse"
              text="Welcome to HappyHouse, a pharetra augue mollis interdum."
              img-src="https://picsum.photos/1024/480/?image=52"
            ></b-carousel-slide>

            <!-- Slides with custom text -->
            <b-carousel-slide img-src="https://picsum.photos/1024/480/?image=54">
              <h1>Hello Guys!</h1>
            </b-carousel-slide>

            <!-- Slides with image only -->
            <b-carousel-slide img-src="https://picsum.photos/1024/480/?image=58"></b-carousel-slide>

            <!-- Slides with img slot -->
            <!-- Note the classes .d-block and .img-fluid to prevent browser default image alignment -->
            <b-carousel-slide>
              <template v-slot:img>
                <img
                  class="d-block img-fluid w-100"
                  width="1024"
                  height="480"
                  src="https://picsum.photos/1024/480/?image=55"
                  alt="image slot"
                >
              </template>
            </b-carousel-slide>
          </b-carousel>
        </div>
        <hr>
        <div class="text-center pt-3 pb-3 mb-3">
          <h1> 아 파 트 실 거 래 정 보 </h1>
        </div>

        <div class="input-group mb-3 mt-4 float-right w-25">
            <input type="text" class="form-control" placeholder="어떤것이 궁금하세요??" aria-label="Recipient's username" aria-describedby="button-addon2">
            <div class="input-group-append">
                <b-button @click="searchContent" >검색</b-button>
            </div>
        </div>
        
        <b-table
            hover
            :items="items"
            :per-page="perPage"
            :current-page="currentPage"
            :fields="fields"
            @row-clicked="rowClick"
        ></b-table>
        <b-pagination v-model="currentPage" :total-rows="rows" :per-page="perPage" align="center"></b-pagination>
        <!--
        <div class="text-right">
          <b-button  @click="writeContent">글쓰기</b-button>
        </div>
        -->
    </div>
</template>

<script>
import data from '@/data'
export default {
  name: 'QnABoard',
  data() {
    let apartItems = data.Apartment.sort((a, b) => {
      return b.dong - a.dong;
    }); // 내림차순

    //User 와 Content 의 user_id 의 같은 번호를 찾아 Content 에 기존자료 + 'user_name' 으로 추가한다.
    let items = apartItems.map(apartItem => {
      return {
        ...apartItem,
        dong: data.Dong.filter(dongItem => {
          return apartItem.dong === dongItem.dong;
        })[0].dong
      };
    });

    return {
      slide: 0,
      sliding: null,
      currentPage: 1, // 현재 페이지
      perPage: 10, // 페이지당 보여줄 갯수
      // bootstrap 'b-table' 필드 설정
      //// buildYear,dealYear,dealMonth,dealDay,dong,dealAmount,AptName,area,code,floor,jibun
      fields: [
        {
          key: "buildYear",
          label: "설립년도"
        },
        {
          key: "dong",
          label: "동이름"
        },
        {
          key: "dealAmount",
          label: "거래금액"
        },
        {
          key: "aptName",
          label: "아파트명"
        },
        {
          key: "area",
          label: "면적"
        },
      ],
      items: items,
    };
  },
  methods: {
    rowClick(item) {
      this.$router.push({
        path: `/board/${item.content_id}`
      });
    },
  },
  computed: {
    rows() {
      return this.items.length;
    }
  }
}
</script>
