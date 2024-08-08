package com.kampus.core.constants.entityConstants;

public class CommunityMemberConstants {
    /**
     * TABLE
     */
    public static final String COMMUNITY_MEMBER_TABLE = "CommunityMembers";


    /**
     * COLUMN
     */
    public static final String COMMUNITY_MEMBER_COLUMN_COMMUNITY_ID = "community_member_id";
    public static final String COMMUNITY_MEMBER_COLUMN_NAME= "name";
    public static final String COMMUNITY_MEMBER_COLUMN_COMMUNITY_DESCRIPTION= "description";
    public static final String COMMUNITY_MEMBER_COLUMN_COMMUNITY_CREATED_BY = "created_by";
    public static final String COMMUNITY_MEMBER_COLUMN_COMMUNITY_JOINED_AT = "joined_at";

    public static final String Role ="role";



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
}
