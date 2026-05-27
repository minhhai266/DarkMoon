<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<section class="login-page">

    <div class="login-bg"></div>
    <div class="login-vignette"></div>

    <div class="login-card">

        <div class="login-symbol">✠</div>

        <p class="login-eyebrow">BƯỚC VÀO MÀN SƯƠNG</p>

        <h1 class="login-title">Khởi Nguyên Tận Diệt</h1>

        <p class="login-subtitle">
            Thế giới phía bên kia đã mục rữa từ lâu.  
            Chỉ những linh hồn bị nguyền rủa mới có thể tiếp tục tiến bước.
        </p>

        <div class="login-divider"></div>

        <div class="google-login-btn">

            <svg viewBox="0 0 48 48">
                <path fill="#EA4335"
                    d="M24 9.5c3.54 0 6.7 1.22 9.2 3.6l6.86-6.86C35.9 2.5 30.4 0 24 0 14.64 0 6.56 5.38 2.6 13.22l7.98 6.19C12.4 13.1 17.7 9.5 24 9.5z"/>
                <path fill="#4285F4"
                    d="M46.5 24.5c0-1.64-.14-3.22-.4-4.74H24v9h12.7c-.55 2.96-2.2 5.46-4.68 7.14l7.28 5.66C43.8 37.2 46.5 31.4 46.5 24.5z"/>
                <path fill="#FBBC05"
                    d="M10.58 28.41A14.5 14.5 0 0 1 9.5 24c0-1.54.26-3.03.73-4.41L2.25 13.4A23.94 23.94 0 0 0 0 24c0 3.84.92 7.47 2.55 10.6l8.03-6.19z"/>
                <path fill="#34A853"
                    d="M24 48c6.48 0 11.92-2.14 15.9-5.82l-7.28-5.66c-2.02 1.36-4.6 2.18-8.62 2.18-6.3 0-11.6-3.6-13.42-8.9l-7.98 6.19C6.56 42.62 14.64 48 24 48z"/>
            </svg>

            <a href="/oauth2/authorization/google">Đăng nhập bằng Google</a>
        </div>

        <p class="login-footer">
            “Bên kia cánh cổng này, lòng nhân từ không còn tồn tại.”
        </p>

    </div>

</section>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>