layui.use('form', function () {
    var form = layui.form;
    layui.form.on('select(category1)', function (data) {
        if (data.value == "") {
            layui.$('#category2').html('<option value="">请选择分类</option>');
            layui.form.render("select");
        }
        else {
            if (data.value == "生活") {
                layui.$('#category2').html('<option value="">请选择分类</option>');
                layui.$('#category2').append(new Option("家政", "家政"));
                layui.$('#category2').append(new Option("代驾", "代驾"));
                layui.$('#category2').append(new Option("跑腿", "跑腿"));
                layui.$('#category2').append(new Option("其他", "其他"));
            }
            else if (data.value == "咨询") {
                layui.$('#category2').html('<option value="">请选择分类</option>');
                layui.$('#category2').append(new Option("考证", "考证"));
                layui.$('#category2').append(new Option("技术", "技术"));
                layui.$('#category2').append(new Option("人文", "人文"));
                layui.$('#category2').append(new Option("其他", "其他"));
            }
            else if (data.value == "娱乐") {
                layui.$('#category2').html('<option value="">请选择分类</option>');
                layui.$('#category2').append(new Option("运动", "运动"));
                layui.$('#category2').append(new Option("摄影", "摄影"));
                layui.$('#category2').append(new Option("音乐", "音乐"));
                layui.$('#category2').append(new Option("其他", "其他"));
            }
            else if (data.value == "紧急") {
                layui.$('#category2').html('<option value="">请选择分类</option>');
                layui.$('#category2').append(new Option("紧急", "紧急"));
            }
            layui.form.render("select");
        }
    });
});