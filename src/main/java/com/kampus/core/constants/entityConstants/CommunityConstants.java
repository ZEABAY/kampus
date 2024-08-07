package com.kampus.core.constants.entityConstants;

public class CommunityConstants {
    /**
     * TABLE
     */
    public static final String COMMUNITY_TABLE = "Communities";


    /**
     * COLUMN
     */
    public static final String COMMUNITY_COLUMN_COMMUNITY_ID = "community_id";
    public static final String COMMUNITY_COLUMN_NAME= "name";
    public static final String COMMUNITY_COLUMN_DESCRIPTION= "description";
    public static final String COMMUNITY_COLUMN_COMMUNITY_CREATED_BY = "created_by";
    public static final String COMMUNITY_COLUMN_CREATED_AT = "created_at";



    public static final String COMMUNITY_MAP_COMMUNITY = "community";


    public static final String CommunityMember = "CommunityMember";


    /**
     * INDEX
     */

    public static final String COMMUNITY_IDX_COMMENT_ID = "idx_community_id";


    /**
     * SEQUENCE
     */
    public static final String COMMUNITY_SEQ_COMMUNITY = "community_seq";
    public static final String COMMUNITY_SEQ_COMMUNITY_ID = "community_id_seq";
    public static final int COMMUNITY_SEQ_COMMUNITY_ID_ALLOCATION_SIZE = 1;
}
