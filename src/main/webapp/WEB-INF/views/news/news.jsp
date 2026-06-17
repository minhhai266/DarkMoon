<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ include file="/WEB-INF/views/layout/header.jsp" %>


<section class="page-hero">
  <div
    class="page-hero-bg"
    style="
      background-image: url(&quot;https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1920&q=80&quot;);
    "
  ></div>
  <div class="page-hero-overlay"></div>
  <div class="page-hero-content">
    <p class="page-hero-eyebrow">&#9670; Viễn thám ký &#9670;</p>
    <h1 class="page-hero-title">Tin tức</h1>
    <p class="page-hero-subtitle">
      Cập nhật tình hình từ tiền tuyến khai phá. Đại nghiệp diễn tiến. Hắc ám
      diên miên.
    </p>
  </div>
</section>

<!-- FEATURED POST -->
<section class="section section-dark">
  <div class="container">
    <div class="section-header">
      <span class="section-eyebrow">Tinh Tuyển</span>
      <h2 class="section-title">Tối Tân Thư Tín</h2>
      <div class="section-divider"></div>
    </div>

    <c:if test="${featuredArticle != null}">
        <div class="news-card-featured">

            <img
                class="news-featured-img"
                src="${featuredArticle.thumbnailUrl}"
                alt="${featuredArticle.title}"
                loading="lazy" />

            <div
                style="
                    padding: 2.5rem;
                    display: flex;
                    flex-direction: column;
                    justify-content: center;
                    background: var(--dark-card);
                ">

                <span class="news-category">
                    &#9670; ${featuredArticle.type}
                </span>

                <span class="news-date">
                    ${featuredArticle.createdAt}
                </span>

                <h2
                    style="
                        font-family: 'Cormorant Garamond', serif;
                        font-size: 1.8rem;
                        color: var(--cream);
                        margin-bottom: 1rem;
                        line-height: 1.3;
                    ">
                    ${featuredArticle.title}
                </h2>

                <p
                    class="font-crimson"
                    style="
                        color: var(--mid-grey);
                        font-size: 1rem;
                        line-height: 1.7;
                        margin-bottom: 1.5rem;
                    ">
                    <!-- ${featuredArticle.summary} -->
                </p>

                <div style="display: flex; gap: 1rem">

                    <a href="/news/${featuredArticle.id}"
                    class="btn btn-primary"
                    style="font-size: 0.68rem">
                        Đọc tiếp
                    </a>

                </div>

            </div>

        </div>
    </c:if>
  </div>
</section>

<!-- NEWS GRID -->
<section id ="news-list" class="section section-surface">
  <div class="container">
    <div class="section-header">
      <span class="section-eyebrow">Tất cả các bản tin</span>
      <h2 class="section-title">Tin tức gần đây</h2>
      <div class="section-divider"></div>
    </div>

    <!-- Filter Tabs -->
    <div
      style="display: flex; gap: 0.5rem; margin-bottom: 2.5rem; flex-wrap: wrap"
    >
      <a
        href="#"
        class="btn btn-primary"
        style="font-size: 0.62rem; padding: 0.4rem 1rem"
        >Tất cả</a
      >
      <a
        href="#"
        class="btn btn-secondary"
        style="font-size: 0.62rem; padding: 0.4rem 1rem"
        >Cập nhật</a
      >
      <a
        href="#"
        class="btn btn-secondary"
        style="font-size: 0.62rem; padding: 0.4rem 1rem"
        >Blog phát triển</a
      >
      <a
        href="#"
        class="btn btn-secondary"
        style="font-size: 0.62rem; padding: 0.4rem 1rem"
        >Cộng đồng</a
      >
      <a
        href="#"
        class="btn btn-secondary"
        style="font-size: 0.62rem; padding: 0.4rem 1rem"
        >DLC</a
      >
    </div>

    <div class="grid-3">

        <c:forEach items="${articles}" var="article">

            <div class="card">

                <img class="card-img"
                    src="${article.thumbnailUrl}"
                    alt="${article.title}"
                    loading="lazy">

                <div class="card-body">

                    <span class="card-tag">
                        ${article.type}
                    </span>

                    <h3 class="card-title">
                        ${article.title}
                    </h3>

                    <!-- <p class="card-text">
                        ${article.summary}
                    </p> -->

                </div>

                <div class="card-footer">

                    <span class="font-Cormorant Garamond text-grey">
                        ${article.createdAt}
                    </span>

                    <a href="/news/${article.id}"
                    class="text-crimson font-Lora">
                        Đọc thêm →
                    </a>

                </div>

            </div>


        </c:forEach>


    </div>
        <c:if test="${hasMore}">
            <div class="text-center mt-4">
                <a href="?limit=${nextLimit}#news-list"
                    class="btn btn-secondary">
                        Hiện thêm
                </a>
            </div>
        </c:if>
    </div>
</section>

<!-- NEWSLETTER
<section
  style="
    background: var(--dark-card);
    border-top: 1px solid var(--border-dark);
    border-bottom: 1px solid var(--border-dark);
    padding: 4rem 2rem;
    text-align: center;
  "
>
  <div class="container-sm">
    <span class="section-eyebrow">Đừng Bỏ Lỡ Bất Kỳ Tin Tức Nào</span>

    <h2 class="section-title">Luôn Nắm Bắt Mọi Diễn Biến</h2>

    <p
      class="font-im-fell"
      style="
        font-size: 1.05rem;
        color: var(--mid-grey);
        margin-bottom: 2rem;
        line-height: 1.7;
      "
    >
      Bóng tối cũng mang theo những thông điệp của riêng nó. Đăng ký để nhận các
      bản cập nhật lớn, ghi chú vá lỗi, và những nội dung nổi bật từ cộng đồng
      trực tiếp gửi đến ngươi.
    </p>

    <form
      style="display: flex; gap: 0.8rem; max-width: 440px; margin: 0 auto"
      onsubmit="return false;"
    >
      <input
        type="email"
        placeholder="diachi@vungdat.com"
        style="
          flex: 1;
          padding: 0.75rem 1rem;
          background: rgba(8, 6, 4, 0.8);
          border: 1px solid var(--border-mid);
          color: var(--cream);
          font-family: &quot;Crimson Text&quot;, serif;
          font-size: 1rem;
          outline: none;
        "
      />

      <button
        type="submit"
        class="btn btn-primary"
        style="white-space: nowrap; font-size: 0.68rem"
      >
        Đăng Ký
      </button>
    </form>
  </div>
</section> -->

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
