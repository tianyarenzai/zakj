/**
 * Created by zhangfan on 2017/6/29.
 */

$(function () {

    $(".pc_mune li").click(function () {
        $(this).addClass("on").siblings().removeClass("on");
    });
    //顶部菜单
    $(".nav-menu li").click(function () {
        $(this).addClass("on").siblings().removeClass("on");
    });
    //主页导航
    $(".nav_mune_left li").click(function () {
        $(this).addClass("on").siblings().removeClass("on");
    });
    $(".add_on a").click(function () {
        $(this).addClass("on").siblings().removeClass("on");
    });

    //中心首页资源切换
    $('.sysNotice_one_icon  a').click(function () {
        var i = $(this).index();//下标第一种写法
        //var i = $('tit').index(this);//下标第二种写法
        $(this).addClass('on').siblings().removeClass('on');
        $('.index_tab ul').eq(i).show().siblings().hide();
    });


//    消息管理

    $(".message_icon_list li:even").css("background", "url(../images/icon_xian.png) no-repeat");
    $(".message_icon_list li:odd").css("background", "url(../images/icon_xian_c.png) no-repeat");
//班级公告
    $(".classBulletin_tab_icon li").click(function () {
        $(".add_newTeam").hide();
        $(".add_classBulletin").hide();
    })
    $(".classBulletin_btn").click(function () {
        var classS = $(".add_classBulletin")
        classS.show();
        $(".add_newTeam").hide();
    });
    $(".newTeam").click(function () {
        $(".add_newTeam").show();
        $(".add_classBulletin").hide();
    });
    //发布新公告
    $("#post_topic").click(function () {
        $(".maskLayer").show();
        $("#addprofile").show();
    });
    //新增小组
    $("#post_topic_add").click(function () {
        $(".maskLayer").show();
        $("#add_newTeam_con").show();
    });
    //发消息
    $("#SendMessage,#SendMessage_parents").click(function () {
        $(".maskLayer").show();
        $(".sendMessage").show();
    });
    //发起研讨
    $(".discussion_btn").click(function () {
        $(".maskLayer").show();
        $(".aDiscussion").show();
    });
    //发布作业--选择班级
    $(".hw_cls").click(function () {
        $(".maskLayer").show();
        $(".checkMember").show();
    });
    //选择收件人
    $(".hw_cls_a").click(function () {
        $(".maskLayer").show();
        $(".SelectRecipient").show();
    });
    //关闭遮罩层
    $(".ShutDown").click(function () {
        $(".maskLayer").hide();
        $("#addprofile").hide();
        $("#add_newTeam_con").hide();
        $(".sendMessage").hide();
        $(".aDiscussion").hide();
        $(".chapter").hide();
        $(".checkMember").hide();
        $(".SelectRecipient").hide();

    });
    $("#groupNumberList li").hover(function () {
        $(this).children(".set-leader").show();
    }, function () {
        $(this).children(".set-leader").hide();
    });
//互动交流-回复列表
    $(".reply_list li .reply").click(function () {
        $(this).parent(".text_bottom").siblings(".replyBasicCon").show();
    });
    $(".reply_list li .class_reply").click(function () {
        $(this).siblings(".replyBasicCon").toggleClass("display");
    })
//新增备课资料
    $(".PreparesLessonPlan li .Prepares_list").hover(function () {
        $(this).children(".seqno").show();
    }, function () {
        $(this).children(".seqno").hide();
    });
    //修改保存备课资料
    $oBtn = $(".clickModify_btn");//点击按钮
    $oSave = $(".clicksave")
    $oDiv = $(".PreparesLessonPlan");//显示区域
    $ohide = $(".saveYour");//隐藏区域


    $oSave.click(function () {
        $(this).hide();
        $(".clickModify_btn").show();
        console.log("修改");
        $oDiv.hide();
        $ohide.show();
    });

    $oBtn.click(function () {
        $(this).hide();
        $oSave.show();
        console.log("修改");
        $oDiv.show();
        $ohide.hide();
    });
//发布作业--选择班级selectClass
    $(".memberList .select_mumber").click(function () {
        console.log("123");
        $(this).children(".person_box_right_header").children(".a").children(".bb").children(".hide").show();
        // $(".hide").toggleClass("show");
    });
    $(".check_all_mumber").click(function () {
        $(".hide").toggleClass("show");
    });

    //备课添加云端资料列表
    $(".cloudData_con_list li").click(function () {
        $(this).children(".right_top").children("img").attr("src", "../../images/icon_xz_a.png");
        $(this).siblings().children(".right_top").children("img").attr("src", "../../images/icon_xz.png");
    });
    $(".moreInformation").click(function () {
        console.log("123");
        $(".doc_info").toggleClass("show");
    });
    $(".JobDescription").click(function () {
        $(".homewo_info_hide").slideToggle();
    });

    $(".TryListing_con_list .AnswerKey_list").click(function () {
        $(this).siblings(".AnswerKey_con").slideToggle();
    })

//上传资源--知识点
    $(".ztree_icon").click(function () {
        $(this).siblings(".ztree").slideToggle();
    });
    $(".input_ztree").click(function () {
        $(this).siblings(".demo_ztree").slideToggle();
    });
    //试卷保存成功
    $(".more-info").click(function () {
        $(this).siblings(".doc-info-wrap").slideToggle();
    });
    //更多
    $oBtn = $(".more");
    $oDiv = $(".hide-form");

    $oBtn.click(function () {
        if ($oDiv.is(":visible")) {
            $oBtn.html("更多展开 <i class='iconfont icon-xiangshang1'></i>");
            $oDiv.slideUp();
        } else {
            $oBtn.html("更多收起<i class='iconfont icon-xiangshang'></i>");
            $oDiv.slideDown();
        }
    });


    //上传资源--试题选择
    $('.stick-top  span').click(function () {
        var i = $(this).index();
        $(this).addClass('on').siblings().removeClass('on');
        $('.stick-tab ul').eq(i - 1).addClass("display").siblings().removeClass("display");
    });
//上传资源--试卷保存成功-修改题目
    $(".see-answer a").click(function () {
        $(this).parent(".see-answer").siblings(".list_answer").slideToggle();
    })
    $(".typeList li:not(:first-child)").click(function () {
        $(this).addClass("on").siblings().removeClass("on");
    })

    //生成试卷
    $(".TryListing_con_list_title .icon-minus-signa").click(function () {
        $(this).toggleClass("icon-minus-sign");
        $(this).parent(".TryListing_con_list_title").siblings("li").slideToggle();
    })




});



//弹出框
function initSection() {
    // var windonW = ((document.body.clientWidth) / 2) - 244 + "px";
    $(".chapter").show().css("left", "50%");

};
initSection();

function abc() {
    $(".uploadingR").show();
}

