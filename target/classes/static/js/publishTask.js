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
                layui.$('#category2').append(new Option("代领", "代领"));
                layui.$('#category2').append(new Option("代送", "代送"));
                layui.$('#category2').append(new Option("其他", "其他"));
            }
            else if (data.value == "学习") {
                layui.$('#category2').html('<option value="">请选择分类</option>');
                layui.$('#category2').append(new Option("计算机", "计算机"));
                layui.$('#category2').append(new Option("数学", "数学"));
                layui.$('#category2').append(new Option("英语", "英语"));
                layui.$('#category2').append(new Option("其他", "其他"));
            }
            else if (data.value == "娱乐") {
                layui.$('#category2').html('<option value="">请选择分类</option>');
                layui.$('#category2').append(new Option("陪玩", "陪玩"));
                layui.$('#category2').append(new Option("陪吃", "陪吃"));
                layui.$('#category2').append(new Option("陪聊", "陪聊"));
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