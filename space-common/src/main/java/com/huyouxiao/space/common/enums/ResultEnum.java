package com.huyouxiao.space.common.enums;

public enum ResultEnum {

  SYSTEM_ERROR_WAIT("-1", "系统繁忙，此时请开发者稍候再试"),
  SUCCESS("0", "请求成功"),
  INVALID_APP_SECRET("40001", "获取 access_token 时 AppSecret 错误，或者 access_token 无效。请开发者认真比对 AppSecret 的正确性，或查看是否正在为恰当的公众号调用接口"),
  INVALID_CREDENTIAL("40002", "不合法的凭证类型"),
  INVALID_OPEN_ID("40003", "不合法的 OpenID ，请开发者确认 OpenID （该用户）是否已关注公众号，或是否是其他公众号的 OpenID"),
  INVALID_MEDIA_TYPE("40004", "不合法的媒体文件类型"),
  INVALID_FILE_TYPE("40005", "不合法的文件类型"),
  INVALID_FILE_SIZE("40006", "不合法的文件大小"),
  INVALID_MEDIA_FILE_ID("40007", "不合法的媒体文件 id"),
  INVALID_MESSAGE_TYPE("40008", "不合法的消息类型"),
  INVALID_PICTURE_FILE_SIZE("40009", "不合法的图片文件大小"),
  INVALID_AUDIO_FILE_SIZE("40010", "不合法的语音文件大小"),
  INVALID_VIDEO_FILE_SIZE("40011", "不合法的视频文件大小"),
  INVALID_THUMBNAIL_FILE_SIZE("40012", "不合法的缩略图文件大小"),
  INVALID_APP_ID("40013", "不合法的 AppID ，请开发者检查 AppID 的正确性，避免异常字符，注意大小写"),
  INVALID_ACCESS_TOKEN("40014", "不合法的 access_token ，请开发者认真比对 access_token 的有效性（如是否过期），或查看是否正在为恰当的公众号调用接口"),
  INVALID_MENU_TYPE("40015", "不合法的菜单类型"),
  INVALID_BUTTON("40016", "不合法的按钮"),
  INVALID_BUTTON_COUNT("40017", "不合法的按钮个数"),

    INVALID_BUTTON_NAME_LENGTH("40018", "不合法的按钮名字长度"),
    INVALID_BUTTON_KEY_LENGTH("40019", "不合法的按钮 KEY 长度"),
    INVALID_BUTTON_URL_LENGTH("40020", "不合法的按钮 URL 长度"),
    INVALID_MENU_VERSION("40021", "不合法的菜单版本号"),
    INVALID_SUB_MENU_LEVEL("40022", "不合法的子菜单级数"),
    INVALID_SUB_MENU_COUNT("40023", "不合法的子菜单按钮个数"),
    INVALID_SUB_MENU_TYPE("40024", "不合法的子菜单按钮类型"),
    INVALID_SUB_MENU_NAME_LENGTH("40025", "不合法的子菜单按钮名字长度"),
    INVALID_SUB_MENU_KEY_LENGTH("40026", "不合法的子菜单按钮 KEY 长度"),
    INVALID_SUB_MENU_URL_LENGTH("40027", "不合法的子菜单按钮 URL 长度"),
    INVALID_SELF_DEFINE_MENU_USER("40028", "不合法的自定义菜单使用用户"),
    INVALID_OAUTH_CODE("40029", "不合法的 oauth_code"),
    INVALID_REFRESH_TOKEN("40030", "不合法的 refresh_token"),
    INVALID_OPEN_ID_LIST("40031", "不合法的 openid 列表"),
    INVALID_OPEN_ID_LIST_LENGTH("40032", "不合法的 openid 列表长度"),
    INVALID_REQUEST_CHARACTERS("40033", "不合法的请求字符, 不能包含 \\uxxxx 格式的字符"),
    INVALID_REQUEST_PARAMETER("40035", "不合法的参数"),
    INVALID_REQUEST_FORMAT("40038", "不合法的请求格式"),
    INVALID_REQUEST_URL("40039", "不合法的 URL 长度"),
    INVALID_GROUP_ID("40050", "不合法的分组 id"),
    INVALID_GROUP_NAME("40051", "分组名字不合法"),
    INVALID_ARTICLE_IDX("40060", "删除单篇图文时，指定的 article_idx 不合法"),
    INVALID_GROUP_NAME_LENGTH("40117", "分组名字长度不合法"),
    INVALID_MEDIA_ID_SIZE("40118", "media_id 大小不合法"),
    UNKNOWN_BUTTON_TYPE("40119", "button 类型错误"),
    MISSING_BUTTON_TYPE("40120", "button 类型错误"),
    INVALID_MEDIA_ID("40121", "不合法的 media_id 类型"),
    INVALID_WE_CHAT("40132", "微信号不合法"),

    INVALID_USER_NAME("49001", "输入的用户名不正确，帐号由5到20个大小写字母组成。"),
    INVALID_USER_PASSWORD("49002", "设置的用户密码不符合要求，由6到20个数字或大小写字母组成。"),
    INVALID_USER_PHONE("49003", "设置的用户手机号不支持，请使用中国移动，电信或者联通的手机号码，不支持座机号。"),
    INVALID_USER_EMAIL("49004", "填写的邮箱地址格式不对。请输入正确的邮箱地址。"),
    USER_PHONE_ALREADY_EXIST("49005", "你输入的手机号已经注册了。"),

    NOT_SUPPORT_PICTURE_FORMAT("40137", "不支持的图片格式"),
    NOT_SUPPORT_URL_LINK("40155", "请勿添加其他公众号的主页链接"),
    REQUIRED_ACCESS_TOKEN("41001", "缺少 access_token 参数"),
    REQUIRED_APP_ID("41002", "缺少 appid 参数"),
    REQUIRED_REFRESH_TOKEN("41003", "缺少 refresh_token 参数"),
    REQUIRED_SECRET("41004", "缺少 secret 参数"),
    REQUIRED_MEDIA_FILE("41005", "缺少多媒体文件数据"),
    REQUIRED_MEDIA_ID("41006", "缺少 media_id 参数"),
    REQUIRED_SUB_MENU_DATA("41007", "缺少子菜单数据"),
    REQUIRED_OAUTH_CODE("41008", "缺少 oauth code"),
    REQUIRED_OPEN_ID("41009", "缺少 openid"),
    EXPIRED_ACCESS_TOKEN("42001", "access_token 超时，请检查 access_token 的有效期，请参考基础支持 - 获取 access_token 中，对 access_token 的详细机制说明"),
    REFRESH_TOKEN_TIMEOUT("42002", "refresh_token 超时"),
    OAUTH_CODE_TIMEOUT("42003", "oauth_code 超时"),
    PASSWORD_CHANGE("42007", "用户修改微信密码， accesstoken 和 refreshtoken 失效，需要重新授权"),
    ONLY_SUPPORT_GET("43001", "需要 GET 请求"),
    ONLY_SUPPORT_POST("43002", "需要 POST 请求"),
    REQUIRED_HTTPS("43003", "需要 HTTPS 请求"),
    REQUIRED_RECEIVER_CONCERN("43004", "需要接收者关注"),
    REQUIRED_FRIEND_RELATIONSHIP("43005", "需要好友关系"),
    RECEIVER_BLACK_LIST_BLOCK("43019", "需要将接收者从黑名单中移除"),
    MEDIA_FILE_EMPTY("44001", "多媒体文件为空"),
    POST_DATA_EMPTY("44002", "POST 的数据包为空"),
    PICTURE_CONTENT_MESSAGE_EMPTY("44003", "图文消息内容为空"),
    CONTENT_MESSAGE_EMPTY("44004", "文本消息内容为空"),
    MEDIA_FILE_SIZE_MAX_LIMIT("45001", "多媒体文件大小超过限制"),
    MESSAGE_LENGTH_MAX_LIMIT("45002", "消息内容超过限制"),
    TITLE_LENGTH_MAX_LIMIT("45003", "标题字段超过限制"),
    DESCRIPTION_LENGTH_MAX_LIMIT("45004", "描述字段超过限制"),
    LINK_FIELD_SIZE_MAX_LIMIT("45005", "链接字段超过限制"),
    PICTURE_LINK_FIELD_MAX_LIMIT("45006", "图片链接字段超过限制"),
    VOICE_PLAY_TIME_MAX_LIMIT("45007", "语音播放时间超过限制"),
    CONTENT_MESSAGE_LENGTH_MAX_LIMIT("45008", "图文消息超过限制"),
    LACK_OF_API_PERMISSION_("45009", "接口调用超过限制"),
    CREATE_MENU_COUNT_MAX_LIMIT("45010", "创建菜单个数超过限制"),
    IGNORE_REQUEST("45011", "API 调用太频繁，请稍候再试"),
    REQUEST_TIMEOUT("45015", "回复时间超过限制"),
    SYSTEM_GROUP_DISABLE_MODIFY("45016", "系统分组，不允许修改"),
    GROUP_NAME_LENGTH_MAX_LIMIT("45017", "分组名字过长"),
    GROUP_SIZE_MAX_LIMIT("45018", "分组数量超过上限"),
    API_CALL_TIME_MAX_LIMIT("45047", "客服接口下行条数超过上限"),
    MEDIA_DATA_NOT_FOUND("46001", "不存在媒体数据"),
    MENU_VERSION_NOT_FOUND("46002", "不存在的菜单版本"),
    MENU_DATA_NOT_FOUND("46003", "不存在的菜单数据"),
    USER_NOT_FOUND("46004", "不存在的用户"),
    ANALYSIS_DATA_ERROR("47001", "解析 JSON/XML 内容错误"),
    UNAUTHORIZED_API("48001", "api 功能未授权，请确认公众号已获得该接口，可以在公众平台官网 - 开发者中心页中查看接口权限"),
    RECEIVER_REJECT_MESSAGE("48002", "粉丝拒收消息（粉丝在公众号选项中，关闭了 “ 接收消息 ” ）"),
    BLACKLIST_API("48004", "api 接口被封禁，请登录 mp.weixin.qq.com 查看详情"),
    FORBIDDEN_API("48005", "api 禁止删除被自动回复和自定义菜单引用的素材"),
    FORBIDDEN_CLEAN_API_CALL_TIMES("48006", "api 禁止清零调用次数，因为清零次数达到上限"),
    SEND_MESSAGE_PERMISSION_DENY("48008", "没有该类型消息的发送权限"),



    UNAUTHORIZED_API_FOR_CALLER("50001", "用户未授权该 api"),
    USER_PERMISSION_DENY("50002", "用户受限，可能是违规后接口被封禁"),
    USER_NOT_CONCERN_WE_CHAT("50005", "用户未关注公众号"),


    INVALID_PARAMETER("61451", "参数错误 (invalid parameter)"),
    INVALID_CLIENT_ACCOUNT("61452", "无效客服账号 (invalid kf_account)"),
    CLIENT_ACCOUNT_EXISTED("61453", "客服帐号已存在 (kf_account exsited)"),
    CLIENT_ACCOUNT_LENGTH_MAX_LIMIT("61454", "客服帐号名长度超过限制 ( 仅允许 10 个英文字符，不包括 @ 及 @ 后的公众号的微信号 )(invalid kf_acount length)"),
    CLIENT_ACCOUNT_INVALID_CHARACTERS("61455", "客服帐号名包含非法字符 ( 仅允许英文 + 数字 )(illegal character in kf_account)"),
    CLIENT_ACCOUNT_COUNT_MAX_LIMIT("61456", "客服帐号个数超过限制 (10 个客服账号 )(kf_account count exceeded)"),
    INVALID_HEADER_IMAGE_FILE_TYPE("61457", "无效头像文件类型 (invalid file type)"),
    SYSTEM_ERROR("61450", "系统错误 (system error)"),
    INVALID_DATE_FORMAT("61500", "日期格式错误"),
    MENU_ID_NOT_EXIST("65301", "不存在此 menuid 对应的个性化菜单"),
    USER_NOT_EXIST("65302", "没有相应的用户"),
    DEFAULT_MENU_NOT_EXIST("65303", "没有默认菜单，不能创建个性化菜单"),
    MATCH_RULE_MESSAGE_EMPTY("65304", "MatchRule 信息为空"),
    CUSTOMER_MENU_COUNT_MAX_LIMIT("65305", "个性化菜单数量受限"),
    NOT_SUPPORT_ACCOUNT_FOR_CUSTOMER_MENU("65306", "不支持个性化菜单的帐号"),
    CUSTOMER_MENU_MESSAGE_EMPTY("65307", "个性化菜单信息为空"),
    LACK_OF_BUTTON_RESPONSE_TYPE("65308", "包含没有响应类型的 button"),
    CUSTOMER_MENU_SWITCH_CLOSE("65309", "个性化菜单开关处于关闭状态"),
    REQUIRED_CITY_ID("65310", "填写了省份或城市信息，国家信息不能为空"),
    REQUIRED_PROVINCES_ID("65311", "填写了城市信息，省份信息不能为空"),
    INVALID_COUNTRY_ID("65312", "不合法的国家信息"),
    INVALID_PROVINCES_ID("65313", "不合法的省份信息"),
    INVALID_CITY_ID("65314", "不合法的城市信息"),
    DOMAIN_URL_LINK_OVER_MAX_LOOP("65316", "该公众号的菜单设置了过多的域名外跳（最多跳转到 3 个域名的链接）"),
    INVALID_URL("65317", "不合法的 URL"),


    INVALID_POST_PARAMETERS("9001001", "POST 数据参数不合法"),
    REMOTE_SERVER_NOT_AVAILABLE("9001002", "远端服务不可用"),
    INVALID_TICKET("9001003", "Ticket 不合法"),
    SHAKE_NEAR_BY_USER_FAIL("9001004", "获取摇周边用户信息失败"),
    GET_BUSINESS_INFO_FAIL("9001005", "获取商户信息失败"),
    GET_OPEN_ID_FAIL("9001006", "获取 OpenID 失败"),
    LACK_OF_UPLOAD_FILE("9001007", "上传文件缺失"),
    INVALID_UPLOAD_FILE_TYPE("9001008", "上传素材的文件类型不合法"),
    INVALID_UPLOAD_FILE_SIZE("9001009", "上传素材的文件尺寸不合法"),
    UPLOAD_FILE_FAIL("9001010", "上传失败"),
    INVALID_ACCOUNT("9001020", "帐号不合法"),
    DEVICE_ADD_FORBIDDEN("9001021", "已有设备激活率低于 50% ，不能新增设备"),
    DEVICE_APPLY_NUMBER_INVALID("9001022", "设备申请数不合法，必须为大于 0 的数字"),
    DEVICE_ID_ALREADY_EXIST("9001023", "已存在审核中的设备 ID 申请"),
    QUERY_DEVICE_ID_COUNT_MAX_SIZE("9001024", "一次查询设备 ID 数量不能超过 50 "),
    INVALID_DEVICE_ID("9001025", "设备 ID 不合法"),
    INVALID_PAGE_ID("9001026", "页面 ID 不合法"),
    INVALID_PAGE_PARAMETER("9001027", "页面参数不合法"),
    DELETE_PAGE_ID_MAX_LIMIT_ONE_TIME("9001028", "一次删除页面 ID 数量不能超过 10"),
    PAGE_ALREADY_EXIST_IN_DEVICE("9001029", "页面已应用在设备中，请先解除应用关系再删除"),
    QUERY_PAGE_ID_MAX_LENGTH("9001030", "一次查询页面 ID 数量不能超过 50"),
    INVALID_DATE_BOUND("9001031", "时间区间不合法"),
    DEVICE_BIND_PAGE_PARAMETER_ERROR("9001032", "保存设备与页面的绑定关系参数错误"),
    INVALID_DEPARTMENT_ID("9001033", "门店 ID 不合法"),
    DEVICE_REMARK_LENGTH_MAX_LIMIT("9001034", "设备备注信息过长"),
    INVALID_APPLY_DEVICE_PARAMETER("9001035", "设备申请参数不合法"),
    INVALID_BEGIN_PARAMETER("9001036", "查询起始值 begin 不合法");


  private String code;
  private String message;

  private ResultEnum(String code, String message) {
    this.code = code;
    this.message = message;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
