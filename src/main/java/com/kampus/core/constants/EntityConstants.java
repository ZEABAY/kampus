package com.kampus.core.constants;

import com.kampus.core.utilities.exceptions.BusinessException;

import static com.kampus.core.handler.BusinessErrorCodes.UTILITY_CLASS_ERROR;

public class EntityConstants {

    private EntityConstants() {
        throw new BusinessException(
                UTILITY_CLASS_ERROR.getCode(),
                UTILITY_CLASS_ERROR.getHttpStatus(),
                UTILITY_CLASS_ERROR.getDescription()
        );
    }


    // City Constants

    /**
     * TABLE
     */
    public static final String CITY_TABLE = "Cities";

    /**
     * COLUMN
     */
    public static final String CITY_COLUMN_CITY_ID = "city_id";
    public static final String CITY_COLUMN_CITY_NAME = "city_name";

    /**
     * SEQUENCE
     */
    public static final String CITY_SEQ_CITY = "city_seq";
    public static final String CITY_SEQ_CITY_ID = "city_id_seq";
    public static final int CITY_SEQ_CITY_ID_ALLOCATION_SIZE = 1;


    // Comment Constants

    /**
     * TABLE
     */
    public static final String COMMENT_TABLE = "Comments";


    /**
     * COLUMN
     */
    public static final String COMMENT_COLUMN_COMMENT_ID = "comment_id";
    public static final String COMMENT_COLUMN_TEXT_CONTENT = "text_content";
    public static final String COMMENT_COLUMN_CREATED_AT = "created_at";

    public static final String COMMENT_MAP_COMMENT = "comment";


    /**
     * INDEX
     */

    public static final String COMMENT_IDX_COMMENT_POST = "idx_comment_post";
    public static final String COMMENT_IDX_COMMENT_USER = "idx_comment_user";
    public static final String COMMENT_IDX_COMMENT_CREATED_AT = "idx_comment_created_at";

    /**
     * SEQUENCE
     */
    public static final String COMMENT_SEQ_COMMENT = "comment_seq";
    public static final String COMMENT_SEQ_COMMENT_ID = "comment_id_seq";
    public static final int COMMENT_SEQ_COMMENT_ID_ALLOCATION_SIZE = 1;


    // CommentLike Constants

    /**
     * TABLE
     */
    public static final String COMMENT_LIKE_TABLE = "CommentLikes";


    /**
     * COLUMN
     */
    public static final String COMMENT_LIKE_COLUMN_LIKE_ID = "like_id";
    public static final String COMMENT_LIKE_COLUMN_CREATED_AT = "created_at";


    /**
     * INDEX
     */

    public static final String COMMENT_LIKE_IDX_COMMENT_LIKE_COMMENT = "idx_comment_like_comment";
    public static final String COMMENT_LIKE_IDX_COMMENT_LIKE_USER = "idx_comment_like_user";

    /**
     * SEQUENCE
     */
    public static final String COMMENT_LIKE_SEQ_COMMENT_LIKE = "comment_like_seq";
    public static final String COMMENT_LIKE_SEQ_COMMENT_LIKE_ID = "comments_like_id_seq";
    public static final int COMMENT_LIKE_SEQ_COMMENT_LIKE_ID_ALLOCATION_SIZE = 1;

    // CommentMedia Constants

    /**
     * TABLE
     */
    public static final String COMMENT_MEDIA_TABLE = "CommentMedias";


    /**
     * COLUMN
     */
    public static final String COMMENT_MEDIA_COLUMN_MEDIA_ID = "media_id";
    public static final String COMMENT_MEDIA_COLUMN_MEDIA_TYPE = "media_type";
    public static final String COMMENT_MEDIA_COLUMN_MEDIA_URL = "media_url";
    public static final String COMMENT_MEDIA_COLUMN_CREATED_AT = "created_at";

    /**
     * SEQUENCE
     */
    public static final String COMMENT_MEDIA_SEQ_COMMENT_MEDIA = "comment_media_seq";
    public static final String COMMENT_MEDIA_SEQ_COMMENT_MEDIA_ID = "comment_media_id_seq";
    public static final int COMMENT_MEDIA_SEQ_COMMENT_MEDIA_ID_ALLOCATION_SIZE = 1;

    // Community Constants

    /**
     * TABLE
     */
    public static final String COMMUNITY_TABLE = "Communities";


    /**
     * COLUMN
     */
    public static final String COMMUNITY_COLUMN_COMMUNITY_ID = "community_id";
    public static final String COMMUNITY_COLUMN_NAME = "name";
    public static final String COMMUNITY_COLUMN_DESCRIPTION = "description";
    public static final String COMMUNITY_COLUMN_COMMUNITY_CREATED_BY = "created_by";
    public static final String COMMUNITY_COLUMN_CREATED_AT = "created_at";

    public static final String COMMUNITY_MAP_COMMUNITY = "community";

    /**
     * INDEX
     */
    public static final String COMMUNITY_IDX_COMMUNITY_ID = "idx_community_id";


    /**
     * SEQUENCE
     */
    public static final String COMMUNITY_SEQ_COMMUNITY = "community_seq";
    public static final String COMMUNITY_SEQ_COMMUNITY_ID = "community_id_seq";
    public static final int COMMUNITY_SEQ_COMMUNITY_ID_ALLOCATION_SIZE = 1;

    // CommunityMember Constants

    /**
     * TABLE
     */
    public static final String COMMUNITY_MEMBER_TABLE = "CommunityMembers";


    /**
     * COLUMN
     */
    public static final String COMMUNITY_MEMBER_COLUMN_COMMUNITY_ID = "community_member_id";
    public static final String COMMUNITY_MEMBER_COLUMN_COMMUNITY_JOINED_AT = "joined_at";
    public static final String COMMUNITY_MEMBER_COLUMN_ROLE = "role";


    /**
     * INDEX
     */

    public static final String COMMUNITY_IDX_COMMENT_ID = "idx_community_member_id";

    public static final String COMMUNITY_IDX_USER_ID = "idx_community_user_id";


    /**
     * SEQUENCE
     */
    public static final String COMMUNITY_MEMBER_SEQ_COMMUNITY = "community_member_seq";
    public static final String COMMUNITY_MEMBER_SEQ_COMMUNITY_ID = "community_member_id_seq";


    public static final int COMMUNITY_MEMBER_SEQ_COMMUNITY_ID_ALLOCATION_SIZE = 1;

    //DeletedConversation Constants

    /**
     * TABLE
     */
    public static final String DELETED_CONVERSATION_TABLE = "DeletedConversations";


    /**
     * COLUMN
     */
    public static final String DELETED_CONVERSATION_COLUMN_DELETED_CONVERSATION_ID = "deleted_conversation_id";
    public static final String DELETED_CONVERSATION_COLUMN_DELETED_AT = "deleted_at";

    /**
     * SEQUENCE
     */
    public static final String DELETED_CONVERSATION_SEQ_DELETED_CONVERSATION = "deleted_conversation_seq";
    public static final String DELETED_CONVERSATION_SEQ_DELETED_CONVERSATION_ID = "deleted_conversation_id_seq";
    public static final int DELETED_CONVERSATION_SEQ_DELETED_CONVERSATION_ID_ALLOCATION_SIZE = 1;

    // DeletedMessage Constants


    /**
     * TABLE
     */
    public static final String DELETED_MESSAGE_TABLE = "DeletedMessages";


    /**
     * COLUMN
     */
    public static final String DELETED_MESSAGE_COLUMN_DELETED_MESSAGE_ID = "deleted_message_id";
    public static final String DELETED_MESSAGE_COLUMN_ORIGINAL_MESSAGE_ID = "original_message_id";
    public static final String DELETED_MESSAGE_COLUMN_DELETED_AT = "deleted_at";

    /**
     * SEQUENCE
     */
    public static final String DELETED_MESSAGE_SEQ_DELETED_MESSAGE = "deleted_msg_seq";
    public static final String DELETED_MESSAGE_SEQ_DELETED_MESSAGE_ID = "deleted_message_id_seq";

    public static final int DELETED_MESSAGE_SEQ_DELETED_MESSAGE_ID_ALLOCATION_SIZE = 1;

    // Follower Constants

    /**
     * TABLE
     */
    public static final String FOLLOWER_TABLE = "Followers";


    /**
     * COLUMN
     */
    public static final String FOLLOWER_COLUMN_FOLLOWER_ID = "follower_id";
    public static final String FOLLOWER_COLUMN_STATUS = "status";
    public static final String FOLLOWER_COLUMN_CREATED_AT = "created_at";

    public static final String FOLLOWER_COLUMN_FOLLOWED_USER_ID = "followed_user_id";
    public static final String FOLLOWER_COLUMN_FOLLOWER_USER_ID = "follower_user_id";


    /**
     * INDEX
     */

    public static final String FOLLOWER_IDX_FOLLOWER = "idx_follower";
    public static final String FOLLOWER_IDX_FOLLOWED = "idx_followed";
    public static final String FOLLOWER_IDX_STATUS = "idx_status";

    /**
     * SEQUENCE
     */
    public static final String FOLLOWER_SEQ_FOLLOWER = "follower_seq";
    public static final String FOLLOWER_SEQ_FOLLOWER_ID = "follower_id_seq";
    public static final int FOLLOWER_SEQ_FOLLOWER_ID_ALLOCATION_SIZE = 1;


    // Inbox Constants

    /**
     * TABLE
     */
    public static final String INBOX_TABLE = "Inboxes";


    /**
     * COLUMN
     */
    public static final String INBOX_COLUMN_INBOX_ID = "inbox_id";
    public static final String INBOX_COLUMN_LAST_MESSAGE = "last_message";
    public static final String INBOX_COLUMN_LAST_SEND_USER_ID = "last_send_user_id";
    public static final String INBOX_COLUMN_INBOX_TYPE = "inbox_type";
    public static final String INBOX_COLUMN_CREATED_AT = "created_at";
    public static final String INBOX_COLUMN_UPDATED_AT = "updated_at";


    /**
     * INDEX
     */

    public static final String INBOX_IDX_INBOX_LAST_UPDATED = "idx_inbox_last_updated";
    public static final String INBOX_IDX_INBOX_LAST_SEND_USER = "idx_inbox_last_send_user";

    /**
     * SEQUENCE
     */
    public static final String INBOX_SEQ_INBOX = "inbox_seq";
    public static final String INBOX_SEQ_INBOX_ID = "inbox_id_seq";
    public static final int INBOX_SEQ_INBOX_ID_ALLOCATION_SIZE = 1;

    // InboxParticipants Constants

    /**
     * TABLE
     */
    public static final String INBOX_PARTICIPANT_TABLE = "InboxParticipants";


    /**
     * COLUMN
     */
    public static final String INBOX_PARTICIPANT_COLUMN_INBOX_PARTICIPANT_ID = "inbox_participant_id";


    /**
     * INDEX
     */

    public static final String INBOX_PARTICIPANT_IDX_INBOX_PARTICIPANT_USER = "idx_inbox_participant_user";
    public static final String INBOX_PARTICIPANT_IDX_INBOX_PARTICIPANT_INBOX = "idx_inbox_participant_inbox";

    /**
     * SEQUENCE
     */
    public static final String INBOX_PARTICIPANT_SEQ_INBOX_PARTICIPANT = "inbox_participant_seq";
    public static final String INBOX_PARTICIPANT_SEQ_INBOX_PARTICIPANT_ID = "inbox_participant_id_seq";
    public static final int INBOX_PARTICIPANT_SEQ_INBOX_PARTICIPANT_ID_ALLOCATION_SIZE = 1;

    // Interest Constants

    /**
     * TABLE
     */
    public static final String INTEREST_TABLE = "Interests";


    /**
     * COLUMN
     */
    public static final String INTEREST_COLUMN_INTEREST_ID = "interest_id";
    public static final String INTEREST_COLUMN_INTEREST_NAME = "interest_name";
    public static final String INTEREST_COLUMN_INTEREST_TYPE = "interest_type";

    public static final String INTEREST_MAP_INTERESTS = "interests";


    /**
     * SEQUENCE
     */
    public static final String INTEREST_SEQ_INTEREST = "interest_seq";
    public static final String INTEREST_SEQ_INTEREST_ID = "interest_id_seq";
    public static final int INTEREST_SEQ_INTEREST_ID_ALLOCATION_SIZE = 1;

    // Major Constants

    /**
     * TABLE
     */
    public static final String MAJOR_TABLE = "Majors";


    /**
     * COLUMN
     */
    public static final String MAJOR_COLUMN_MAJOR_ID = "major_id";
    public static final String MAJOR_COLUMN_MAJOR_NAME = "major_name";


    /**
     * SEQUENCE
     */
    public static final String MAJOR_SEQ_MAJOR = "major_seq";
    public static final String MAJOR_SEQ_MAJOR_ID = "major_id_seq";
    public static final int MAJOR_SEQ_MAJOR_ID_ALLOCATION_SIZE = 1;

    // Message Constants

    /**
     * TABLE
     */
    public static final String MESSAGE_TABLE = "Messages";


    /**
     * COLUMN
     */
    public static final String MESSAGE_COLUMN_MESSAGE_ID = "message_id";
    public static final String MESSAGE_COLUMN_MESSAGE_CONTENT = "message_content";
    public static final String MESSAGE_COLUMN_MEDIA_URL = "media_url";
    public static final String MESSAGE_COLUMN_MESSAGE_TYPE = "message_type";
    public static final String MESSAGE_COLUMN_CREATED_AT = "created_at";
    public static final String MESSAGE_COLUMN_UPDATED_AT = "updated_at";
    public static final String MESSAGE_COLUMN_IS_DELETED = "is_deleted";


    /**
     * INDEX
     */

    public static final String MESSAGE_IDX_MESSAGE_INBOX_CREATED_AT = "idx_message_inbox_created_at";
    public static final String MESSAGE_COLUMN_LIST = INBOX_COLUMN_INBOX_ID + ", " + MESSAGE_COLUMN_CREATED_AT;
    /**
     * SEQUENCE
     */
    public static final String MESSAGE_SEQ_MESSAGE = "message_seq";
    public static final String MESSAGE_SEQ_MESSAGE_ID = "message_id_seq";
    public static final int MESSAGE_SEQ_MESSAGE_ID_ALLOCATION_SIZE = 1;

    // Post Constants

    /**
     * TABLE
     */
    public static final String POST_TABLE = "Posts";


    /**
     * COLUMN
     */
    public static final String POST_COLUMN_POST_ID = "post_id";
    public static final String POST_COLUMN_CONTENT_TYPE = "content_type";
    public static final String POST_COLUMN_TEXT_CONTENT = "text_content";
    public static final String POST_COLUMN_LIKE_COUNT = "like_count";
    public static final String POST_COLUMN_COMMENT_COUNT = "comment_count";
    public static final String POST_COLUMN_CREATED_AT = "created_at";
    public static final String POST_COLUMN_UPDATED_AT = "updated_at";

    public static final String POST_MAP_POSTS = "post";


    /**
     * INDEX
     */

    public static final String POST_IDX_POST_USER = "idx_post_user";
    public static final String POST_IDX_POST_CREATED_AT = "idx_post_created_at";
    public static final String POST_IDX_POST_UPDATED_AT = "idx_post_updated_at";

    /**
     * SEQUENCE
     */
    public static final String POST_SEQ_POST = "post_seq";
    public static final String POST_SEQ_POST_ID = "post_id_seq";
    public static final int POST_SEQ_POST_ID_ALLOCATION_SIZE = 1;

    // PostLike Constants

    /**
     * TABLE
     */
    public static final String POST_LIKE_TABLE = "PostLikes";


    /**
     * COLUMN
     */
    public static final String POST_LIKE_COLUMN_LIKE_ID = "like_id";
    public static final String POST_LIKE_COLUMN_CREATED_AT = "created_at";


    /**
     * INDEX
     */

    public static final String POST_LIKE_IDX_POST_LIKE_POST = "idx_post_like_post";
    public static final String POST_LIKE_IDX_POST_LIKE_USER = "idx_post_like_user";

    /**
     * SEQUENCE
     */
    public static final String POST_LIKE_SEQ_POST_LIKE = "post_like_seq";
    public static final String POST_LIKE_SEQ_POST_LIKE_ID = "post_like_id_seq";
    public static final int POST_LIKE_SEQ_POST_LIKE_ID_ALLOCATION_SIZE = 1;

    //PostMedia Constants

    /**
     * TABLE
     */
    public static final String POST_MEDIA_TABLE = "PostMedias";


    /**
     * COLUMN
     */
    public static final String POST_MEDIA_COLUMN_MEDIA_ID = "media_id";
    public static final String POST_MEDIA_COLUMN_MEDIA_TYPE = "media_type";
    public static final String POST_MEDIA_COLUMN_MEDIA_URL = "media_url";
    public static final String POST_MEDIA_COLUMN_CREATED_AT = "created_at";


    /**
     * INDEX
     */

    public static final String POST_MEDIA_IDX_POST_MEDIA_POST = "idx_post_media_post";
    public static final String POST_MEDIA_IDX_POST_MEDIA_CREATED_AT = "idx_post_media_created_at";

    /**
     * SEQUENCE
     */
    public static final String POST_MEDIA_SEQ_POST_MEDIA = "post_media_seq";
    public static final String POST_MEDIA_SEQ_POST_MEDIA_ID = "post_media_id_seq";
    public static final int POST_MEDIA_SEQ_POST_MEDIA_ID_ALLOCATION_SIZE = 1;

    //Reply Constants

    /**
     * TABLE
     */
    public static final String REPLY_TABLE = "Replies";


    /**
     * COLUMN
     */
    public static final String REPLY_COLUMN_REPLY_ID = "reply_id";
    public static final String REPLY_COLUMN_LIKE_COUNT = "like_count";
    public static final String REPLY_COLUMN_CONTENT_TYPE = "content_type";
    public static final String REPLY_COLUMN_CREATED_AT = "created_at";


    /**
     * INDEX
     */

    public static final String REPLY_IDX_REPLY_USER = "idx_reply_user";
    public static final String REPLY_IDX_REPLY_COMMENT = "idx_reply_comment";
    public static final String REPLY_IDX_REPLY_CREATED_AT = "idx_reply_created_at";

    /**
     * SEQUENCE
     */
    public static final String REPLY_SEQ_REPLY = "reply_seq";
    public static final String REPLY_SEQ_REPLY_ID = "reply_id_seq";
    public static final int REPLY_SEQ_REPLY_ID_ALLOCATION_SIZE = 1;

    // SeenMessage Constants

    /**
     * TABLE
     */
    public static final String SEEN_MESSAGE_TABLE = "SeenMessages";


    /**
     * COLUMN
     */
    public static final String SEEN_MESSAGE_COLUMN_SEEN_MESSAGE_ID = "seen_message_id";
    public static final String SEEN_MESSAGE_COLUMN_SEEN_AT = "seen_at";


    /**
     * INDEX
     */

    public static final String SEEN_MESSAGE_IDX_SEEN_MESSAGE_MESSAGE = "idx_seen_message_message";
    public static final String SEEN_MESSAGE_IDX_SEEN_MESSAGE_USER = "idx_seen_message_user";
    public static final String SEEN_MESSAGE_IDX_SEEN_MESSAGE_SEEN_AT = "idx_seen_message_seen_at";

    /**
     * SEQUENCE
     */
    public static final String SEEN_MESSAGE_SEQ_SEEN_MESSAGE = "seen_msg_seq";
    public static final String SEEN_MESSAGE_SEQ_SEEN_MESSAGE_ID = "seen_msg_id_seq";
    public static final int SEEN_MESSAGE_SEQ_SEEN_MESSAGE_ID_ALLOCATION_SIZE = 1;

    // Story Constants

    /**
     * TABLE
     */
    public static final String STORY_TABLE = "Stories";


    /**
     * COLUMN
     */
    public static final String STORY_COLUMN_STORY_ID = "story_ıd";
    public static final String STORY_COLUMN_STORY_TYPE = "story_type";
    public static final String STORY_COLUMN_STORY_URL = "story_url";
    public static final String STORY_COLUMN_CREATED_AT = "created_at";


    /**
     * INDEX
     */

    public static final String STORY_IDX_STORY_USER = "idx_story_user";
    public static final String STORY_IDX_STORY_CREATED_AT = "idx_story_created_at";

    /**
     * SEQUENCE
     */
    public static final String STORY_SEQ_STORY = "story_seq";
    public static final String STORY_SEQ_STORY_ID = "story_id_seq";
    public static final int STORY_SEQ_STORY_ID_ALLOCATION_SIZE = 1;

    // University Constants

    /**
     * TABLE
     */
    public static final String UNIVERSITY_TABLE = "Universities";


    /**
     * COLUMN
     */
    public static final String UNIVERSITY_COLUMN_UNIVERSITY_ID = "university_id";
    public static final String UNIVERSITY_COLUMN_UNIVERSITY_NAME = "university_name";

    /**
     * SEQUENCE
     */
    public static final String UNIVERSITY_SEQ_UNIVERSITY = "university_seq";
    public static final String UNIVERSITY_SEQ_UNIVERSITY_ID = "university_id_seq";
    public static final int UNIVERSITY_SEQ_UNIVERSITY_ID_ALLOCATION_SIZE = 1;

    // UserBan Constants

    /**
     * TABLE
     */
    public static final String USER_BAN_TABLE = "UserBans";


    /**
     * COLUMN
     */
    public static final String USER_BAN_COLUMN_BAN_ID = "ban_id";
    public static final String USER_BAN_COLUMN_REASON = "reason";
    public static final String USER_BAN_COLUMN_BANNED_AT = "banned_at";

    public static final String USER_BAN_COLUMN_BANNED_USER_ID = "banned_user_id";
    public static final String USER_BAN_COLUMN_BANNED_BY_USER_ID = "banned_by_user_id";


    /**
     * SEQUENCE
     */
    public static final String USER_BAN_SEQ_USER_BAN = "user_ban_seq";
    public static final String USER_BAN_SEQ_USER_BAN_ID = "user_ban_id_seq";
    public static final int USER_BAN_SEQ_USER_BAN_ID_ALLOCATION_SIZE = 1;

    // UserComplainReport Constants

    /**
     * TABLE
     */
    public static final String USER_COMPLAIN_REPORT_TABLE = "UserComplainReports";


    /**
     * COLUMN
     */
    public static final String USER_COMPLAIN_REPORT_COLUMN_REPORT_ID = "report_id";
    public static final String USER_COMPLAIN_REPORT_COLUMN_REPORT_TYPE = "report_type";
    public static final String USER_COMPLAIN_REPORT_COLUMN_CREATED_AT = "created_at";
    public static final String USER_COMPLAIN_REPORT_COLUMN_REPORTER_ID = "reporter_id";
    public static final String USER_COMPLAIN_REPORT_COLUMN_REPORTED_ID = "reported_id";

    /**
     * SEQUENCE
     */
    public static final String USER_COMPLAIN_REPORT_SEQ_USER_COMPLAIN_REPORT = "user_complain_report_seq";
    public static final String USER_COMPLAIN_REPORT_SEQ_USER_COMPLAIN_REPORT_ID = "user_complain_report_id_seq";
    public static final int USER_COMPLAIN_REPORT_SEQ_USER_COMPLAIN_REPORT_ID_ALLOCATION_SIZE = 1;

    // User Constants

    /**
     * TABLE
     */
    public static final String USER_TABLE = "Users";
    public static final String USER_INTEREST_TABLE = "UserInterests";


    /**
     * COLUMN
     */
    public static final String USER_COLUMN_USER_ID = "user_id";
    public static final String USER_COLUMN_USERNAME = "username";
    public static final String USER_COLUMN_PASSWORD = "password";
    public static final String USER_COLUMN_MAIL = "mail";
    public static final String USER_COLUMN_FIRST_NAME = "first_name";
    public static final String USER_COLUMN_LAST_NAME = "last_name";
    public static final String USER_COLUMN_PHONE_NUMBER = "phone_number";
    public static final String USER_COLUMN_BIRTH_DATE = "birth_date";
    public static final String USER_COLUMN_BIOGRAPHY = "biography";
    public static final String USER_COLUMN_PROFILE_PIC_URL = "profile_pic_url";
    public static final String USER_COLUMN_AVATAR_URL = "avatar_url";
    public static final String USER_COLUMN_ROLE = "role";
    public static final String USER_COLUMN_IS_PRIVATE = "is_private";
    public static final String USER_COLUMN_CREATED_AT = "created_at";
    public static final String USER_COLUMN_UPDATED_AT = "updated_at";
    public static final String USER_COLUMN_CURRENT_SITUATION = "current_situation";
    public static final String USER_COLUMN_STATUS = "status";

    public static final String USER_MAP_USER = "user";

    /**
     * INDEX
     */

    public static final String USER_IDX_USER_MAIL = "idx_user_mail";
    public static final String USER_IDX_USER_USERNAME = "idx_user_username";

    /**
     * SEQUENCE
     */
    public static final String USER_SEQ_USER = "user_seq";
    public static final String USER_SEQ_USER_ID = "user_id_seq";
    public static final int USER_SEQ_USER_ID_ALLOCATION_SIZE = 1;

    // UserVerification Constants

    /**
     * TABLE
     */
    public static final String USER_VERIFICATION_TABLE = "UserVerifications";


    /**
     * COLUMN
     */
    public static final String USER_VERIFICATION_COLUMN_VERIFICATION_ID = "verification_id";
    public static final String USER_VERIFICATION_COLUMN_VERIFICATION_CODE = "verification_code";
    public static final String USER_VERIFICATION_COLUMN_CREATED_AT = "created_at";
    public static final String USER_VERIFICATION_COLUMN_HAVE_USED = "have_used";

    /**
     * SEQUENCE
     */
    public static final String USER_VERIFICATION_SEQ_USER_VERIFICATION = "user_verification_seq";
    public static final String USER_VERIFICATION_SEQ_USER_VERIFICATION_ID = "user_verification_id_seq";
    public static final int USER_VERIFICATION_SEQ_USER_VERIFICATION_ID_ALLOCATION_SIZE = 1;

}
