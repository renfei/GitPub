<@spring.message "language"/>
<span><a href="javascript:void(0)" onclick="changeLanguage('zh_CN')">中文简体</a></span>
<span><a href="javascript:void(0)" onclick="changeLanguage('en_US')">EN</a></span>
<script type="text/javascript" src="//cdn.neilren.com/neilren4j/1.0.0/js/jquery.min.js"></script>
<script>
    function changeLanguage(language) {
        $.ajax({
            type: "POST",
            url: "/global/set",
            data: "lang=" + language,
            dataType: "json",
            async: true,
            error: function (data, error) {
                alert("change lang error!");
            },
            success: function (data) {
                if (data.state == 200)
                    window.location.reload();
            }
        });
    }
</script>