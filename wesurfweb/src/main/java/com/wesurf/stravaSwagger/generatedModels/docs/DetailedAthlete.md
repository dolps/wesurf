
# DetailedAthlete

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Integer** | The unique identifier of the athlete |  [optional]
**resourceState** | **Integer** | Resource state, indicates level of detail. Possible values: 1 -&gt; \&quot;meta\&quot;, 2 -&gt; \&quot;summary\&quot;, 3 -&gt; \&quot;detail\&quot; |  [optional]
**firstname** | **String** | The athlete&#39;s first name. |  [optional]
**lastname** | **String** | The athlete&#39;s last name. |  [optional]
**profileMedium** | **String** | URL to a 62x62 pixel profile picture. |  [optional]
**profile** | **String** | URL to a 124x124 pixel profile picture. |  [optional]
**city** | **String** | The athlete&#39;s city. |  [optional]
**state** | **String** | The athlete&#39;s state or geographical region. |  [optional]
**country** | **String** | The athlete&#39;s country. |  [optional]
**sex** | [**SexEnum**](#SexEnum) | The athlete&#39;s sex. |  [optional]
**friend** | [**FriendEnum**](#FriendEnum) | Whether the currently logged-in athlete follows this athlete. |  [optional]
**follower** | [**FollowerEnum**](#FollowerEnum) | Whether this athlete follows the currently logged-in athlete. |  [optional]
**premium** | **Boolean** | The athlete&#39;s premium status. |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The time at which the athlete was created. |  [optional]
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The time at which the athlete was last updated. |  [optional]
**followerCount** | **Integer** | The athlete&#39;s follower count. |  [optional]
**friendCount** | **Integer** | The athlete&#39;s friend count. |  [optional]
**mutualFriendCount** | **Integer** | The number or athletes mutually followed by this athlete and the currently logged-in athlete. |  [optional]
**measurementPreference** | [**MeasurementPreferenceEnum**](#MeasurementPreferenceEnum) | The athlete&#39;s preferred unit system. |  [optional]
**email** | **String** | The athlete&#39;s email address. |  [optional]
**ftp** | **Integer** | The athlete&#39;s FTP (Functional Threshold Power). |  [optional]
**weight** | **Float** | The athlete&#39;s weight. |  [optional]
**clubs** | [**List&lt;SummaryClub&gt;**](SummaryClub.md) | The athlete&#39;s clubs. |  [optional]
**bikes** | [**List&lt;SummaryGear&gt;**](SummaryGear.md) | The athlete&#39;s bikes. |  [optional]
**shoes** | [**List&lt;SummaryGear&gt;**](SummaryGear.md) | The athlete&#39;s shoes. |  [optional]


<a name="SexEnum"></a>
## Enum: SexEnum
Name | Value
---- | -----
M | &quot;M&quot;
F | &quot;F&quot;


<a name="FriendEnum"></a>
## Enum: FriendEnum
Name | Value
---- | -----
PENDING | &quot;pending&quot;
ACCEPTED | &quot;accepted&quot;
BLOCKED | &quot;blocked&quot;


<a name="FollowerEnum"></a>
## Enum: FollowerEnum
Name | Value
---- | -----
PENDING | &quot;pending&quot;
ACCEPTED | &quot;accepted&quot;
BLOCKED | &quot;blocked&quot;


<a name="MeasurementPreferenceEnum"></a>
## Enum: MeasurementPreferenceEnum
Name | Value
---- | -----
FEET | &quot;feet&quot;
METERS | &quot;meters&quot;



