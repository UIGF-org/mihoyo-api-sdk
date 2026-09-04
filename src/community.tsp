import "@typespec/http";
import "@uigf/typespec-ds";

using TypeSpec.Http;

/** MiYouShe (CN community) forum, post, task, and check-in APIs. */
@service(#{ title: "UIGF MiYouShe Community API" })
@server("https://bbs-api.miyoushe.com", "MiYouShe Community API")
namespace UIGF.Community;

model CommunityPaging {
  @query
  offset?: int32;

  @query
  size?: int32;

  @query
  last_id?: string;
}

model ForumQuery {
  @query
  gids: string;
}

model PostQuery {
  @query("post_id")
  postId: string;

  @query
  gids?: string;

  @query
  read?: int32;
}

model PostReplyQuery extends PostQuery {
  @query("last_id")
  lastId?: string;

  @query
  size?: int32;
}

model ReplyQuery {
  @query("post_id")
  postId: string;

  @query("reply_id")
  replyId: string;

  @query("last_id")
  lastId?: string;

  @query
  size?: int32;
}

model LikePostRequest {
  post_id: string;
  is_cancel: boolean;
}

model SignInRequest {
  gids: int32;
}

model FavoritePostRequest {
  post_id: string;
  is_cancel: boolean;
}

model VerificationCreateRequest extends Record<unknown> {
  action_type: string;
  /** Vendor-specific verification scene and optional request metadata. */
}

model VerificationSubmitRequest extends Record<unknown> {
  challenge: string;
  validate: string;
  seccode?: string;
}

model LunaCheckInRequest extends Record<unknown> {
  act_id: string;
  /** Optional vendor region/host information. */
}

model Post extends Record<unknown> {
  post_id?: string;
  subject?: string;
  content?: string;
  created_at?: int64;
  user?: CommunityUser;
  images?: JsonObject[];
}

model PostList extends Record<unknown> {
  list?: Post[];
  is_last?: boolean;
  last_id?: string;
}

model Forum extends Record<unknown> {
  id?: int32;
  game_id?: int32;
  name?: string;
  icon?: string;
}

model ForumList extends Record<unknown> {
  list?: Forum[];
}

@route("/user/wapi")
interface UserApi {
  /** Gets the authenticated or public MiYouShe user profile. */
  @get
  @route("/getUserFullInfo")
  getFullInfo(
    @query gids: string,
    @query uid?: string,
    @header("Cookie") cookie?: string,
    @header("DS") ds?: string,
  ): ApiResponse<CommunityUser>;
}

@route("/misc/api")
interface MiscApi {
  @get
  @route("/emoticon_set")
  getEmoticonSet(): ApiResponse<JsonObject>;

  /** Creates the official verification challenge required by selected operations. */
  @post
  @route("/createVerification")
  createVerification(
    @header("Cookie") cookie: string,
    @body body: VerificationCreateRequest,
  ): ApiResponse<JsonObject>;

  /** Submits verification output obtained from the official challenge provider. */
  @post
  @route("/verifyVerification")
  verifyVerification(
    @header("Cookie") cookie: string,
    @body body: VerificationSubmitRequest,
  ): ApiResponse<JsonObject>;

  @get
  @route("/getGeetestChallenge")
  getGeetestChallenge(
    @header("Cookie") cookie: string,
    @query action_type?: string,
  ): ApiResponse<JsonObject>;
}

@route("/collection/wapi/collection")
@UIGF.Security.requiresDs("v1")
interface CollectionApi {
  @get
  @route("/detail")
  getDetail(
    @query gids: int32,
    @query id: string,
    @header("DS") ds?: string,
  ): ApiResponse<JsonObject>;
}

@route("/common/homutreasure/v1/web/user")
@UIGF.Security.requiresDs("v2")
interface CoinRecordApi {
  /** Returns MiYouShe coin earnings or spending records. */
  @get
  @route("/record")
  list(
    @header("Cookie") cookie: string,
    @header("DS") ds: string,
    @query app_id: string = "1",
    @query point_sn: string = "myb",
    @query time: string = "0",
    @query action: "1" | "2" = "1",
    @query size: int32 = 20,
  ): ApiResponse<JsonObject>;
}

@route("/post/wapi")
interface PostApi {
  @get
  @route("/getPostFull")
  getFull(@header("Cookie") cookie?: string, ...PostQuery): ApiResponse<Post>;

  @get
  @route("/getPostFullInCollection")
  getFullInCollection(
    @query collection_id: string,
    @query post_id: string,
    @query gids: string,
  ): ApiResponse<Post>;

  @get
  @route("/getPostReplies")
  getReplies(...PostReplyQuery): ApiResponse<PostList>;

  @get
  @route("/getSubReplies")
  getSubReplies(...ReplyQuery): ApiResponse<PostList>;

  @get
  @route("/getTopicPostList")
  getTopicPosts(
    @query gids: string,
    @query topic_id: string,
    ...CommunityPaging,
  ): ApiResponse<PostList>;

  @get
  @route("/userPost")
  getUserPosts(
    @query uid: string,
    @query gids: string,
    ...CommunityPaging,
  ): ApiResponse<PostList>;

  @get
  @route("/searchPosts")
  search(
    @query gids: string,
    @query keyword: string,
    ...CommunityPaging,
  ): ApiResponse<PostList>;

  @post
  @route("/userFavoritePost")
  @UIGF.Security.requiresDs("v1")
  setFavorite(
    @header("Cookie") cookie: string,
    @header("DS") ds: string,
    @body body: FavoritePostRequest,
  ): ApiResponse<JsonObject>;
}

@route("/painter/wapi")
interface FeedApi {
  @get
  @route("/getNewsList")
  getNews(@query gids: string, ...CommunityPaging): ApiResponse<PostList>;

  @get
  @route("/getHotForumPostList")
  getHotForumPosts(
    @query gids: string,
    ...CommunityPaging,
  ): ApiResponse<PostList>;

  @get
  @route("/getRecentForumPostList")
  getRecentForumPosts(
    @query gids: string,
    ...CommunityPaging,
  ): ApiResponse<PostList>;

  @get
  @route("/getTimelineList")
  getTimeline(@query gids: string, ...CommunityPaging): ApiResponse<PostList>;

  @get
  @route("/lotteryUserShow")
  getLotteryUserShow(@query lottery_id: string): ApiResponse<JsonObject>;
}

@route("/topic/wapi")
interface TopicApi {
  @get
  @route("/getTopicFullInfo")
  getFullInfo(@query gids: string, @query id: string): ApiResponse<JsonObject>;
}

@route("/apihub")
@UIGF.Security.requiresDs("v2")
interface ApiHub {
  @get
  @route("/wapi/getAllGamesForums")
  getAllGamesForums(): ApiResponse<ForumList>;

  @get
  @route("/api/getAppConfig")
  getAppConfig(@query gid?: string): ApiResponse<JsonObject>;

  @get
  @route("/wapi/getGameList")
  getGameList(): ApiResponse<ForumList>;

  @get
  @route("/wapi/getMissions")
  getMissions(
    @header("Cookie") cookie: string,
    @header("DS") ds: string,
    @query point_sn: string = "myb",
  ): ApiResponse<JsonObject>;

  @get
  @route("/api/getShareConf")
  @UIGF.Security.requiresDs("v1")
  getShareConfig(
    @header("Cookie") cookie: string,
    @header("DS") ds: string,
    @query entity_id: string,
    @query entity_type: int32 = 1,
  ): ApiResponse<JsonObject>;

  @get
  @route("/wapi/getUserMissionsState")
  getMissionState(
    @header("Cookie") cookie: string,
    @header("DS") ds: string,
    @query point_sn: string = "myb",
  ): ApiResponse<JsonObject>;

  @get
  @route("/api/getVotes")
  getVotes(
    @query owner_uid: string,
    @query vote_ids: string,
  ): ApiResponse<JsonObject>;

  @get
  @route("/api/getVotesResult")
  getVoteResults(
    @query owner_uid: string,
    @query vote_ids: string,
  ): ApiResponse<JsonObject>;

  @get
  @route("/api/home/new")
  getHome(@query gids: int32 = 2): ApiResponse<JsonObject>;

  @post
  @route("/app/api/signIn")
  signIn(
    @header("Cookie") cookie: string,
    @header("DS") ds: string,
    @header("x-rpc-challenge") challenge?: string,
    @body body: SignInRequest,
  ): ApiResponse<JsonObject>;

  @post
  @route("/api/upvotePost")
  @UIGF.Security.requiresDs("v1")
  setPostVote(
    @header("Cookie") cookie: string,
    @header("DS") ds: string,
    @body body: LikePostRequest,
  ): ApiResponse<JsonObject>;
}
