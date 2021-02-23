/*
 * MIT License
 *
 * Copyright (c) 2021 Al Shakib (shakib@alshakib.dev)
 *
 * This file is part of Extensions
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dev.alshakib.ext;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;

import androidx.annotation.NonNull;

public final class MediaMetadataCompatExt {
    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return Whether the media is an advertisement. A value of 0 indicates it is not an advertisement.
     *          A value of 1 or non-zero indicates it is an advertisement.
     *          If not specified, this value is set to 0 by default.
     */
    public static long getAdvertisement(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_ADVERTISEMENT);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                The system defined metadata keys must use the appropriate data type.
     * @param advertisement Whether the media is an advertisement. A value of 0 indicates it is not an advertisement
     *                      A value of 1 or non-zero indicates it is an advertisement.
     *                      If not specified, this value is set to 0 by default.
     */
    public static void setAdvertisement(@NonNull MediaMetadataCompat.Builder builder,
                                        long advertisement) {
        builder.putLong(MediaMetadataCompat.METADATA_KEY_ADVERTISEMENT, advertisement);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                The system defined metadata keys must use the appropriate data type.
     * @param advertisement Whether the media is an advertisement.
     *                      A value of 0 indicates it is not an advertisement.
     *                      A value of 1 or non-zero indicates it is an advertisement.
     *                      If not specified, this value is set to 0 by default.
     */
    public static void setAdvertisement(@NonNull MediaMetadataCompat.Builder builder,
                                        boolean advertisement) {
        if (advertisement) {
            setAdvertisement(builder, 1);
        } else {
            setAdvertisement(builder, 0);
        }
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return The album title for the media.
     */
    public static String getAlbum(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_ALBUM);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                The system defined metadata keys must use the appropriate data type.
     * @param album The album title for the media.
     */
    public static void setAlbum(@NonNull MediaMetadataCompat.Builder builder,
                                String album) {
        builder.putString(MediaMetadataCompat.METADATA_KEY_ALBUM, album);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return The artwork for the album of the media's original source as a {@link Bitmap}.
     *          The artwork should be relatively small and may be scaled down if it is too large.
     *          For higher resolution artwork {@link #setAlbumArtUri(MediaMetadataCompat.Builder, Uri)} should be used instead.
     */
    public static Bitmap getAlbumArt(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getBitmap(MediaMetadataCompat.METADATA_KEY_ALBUM_ART);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                The system defined metadata keys must use the appropriate data type.
     * @param bitmapArt The artwork for the album of the media's original source as a {@link Bitmap}.
     *                   The artwork should be relatively small and may be scaled down if it is too large.
     *                   For higher resolution artwork {@link #setAlbumArtUri(MediaMetadataCompat.Builder, Uri)} should be used instead.
     */
    public static void setAlbumArt(@NonNull MediaMetadataCompat.Builder builder,
                                   Bitmap bitmapArt) {
        builder.putBitmap(MediaMetadataCompat.METADATA_KEY_ALBUM_ART, bitmapArt);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return The artist for the album of the media's original source.
     */
    public static String getAlbumArtist(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                The system defined metadata keys must use the appropriate data type.
     * @param albumArtist The artist for the album of the media's original source.
     */
    public static void setAlbumArtist(@NonNull MediaMetadataCompat.Builder builder,
                                      String albumArtist) {
        builder.putString(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST, albumArtist);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return The artwork for the album of the media's original source as a {@link Uri}.
     */
    @NonNull
    public static Uri getAlbumArtUri(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return StringExt.toUri(mediaMetadataCompat
                .getString(MediaMetadataCompat.METADATA_KEY_ALBUM_ART_URI));
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                The system defined metadata keys must use the appropriate data type.
     * @param albumArtUri The artwork for the album of the media's original source as a {@link Uri}.
     */
    public static void setAlbumArtUri(@NonNull MediaMetadataCompat.Builder builder,
                                      Uri albumArtUri) {
        builder.putString(MediaMetadataCompat.METADATA_KEY_ALBUM_ART_URI, StringExt.toString(albumArtUri));
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                The system defined metadata keys must use the appropriate data type.
     * @param albumArtUri The artwork for the album of the media's original source as a Uri style String.
     */
    public static void setAlbumArtUri(@NonNull MediaMetadataCompat.Builder builder,
                                      String albumArtUri) {
        builder.putString(MediaMetadataCompat.METADATA_KEY_ALBUM_ART_URI, albumArtUri);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return The artwork for the media as a {@link Bitmap}.
     *          The artwork should be relatively small and may be scaled down if it is too large.
     *          For higher resolution artwork {@link #getArtUri(MediaMetadataCompat)} should be used instead.
     */
    public static Bitmap getArt(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getBitmap(MediaMetadataCompat.METADATA_KEY_ART);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                The system defined metadata keys must use the appropriate data type.
     * @param art The artwork for the media as a {@link Bitmap}.
     *           The artwork should be relatively small and may be scaled down if it is too large.
     *           For higher resolution artwork {@link #setArtUri(MediaMetadataCompat.Builder, Uri)} should be used instead.
     */
    public static void setArt(@NonNull MediaMetadataCompat.Builder builder,
                              Bitmap art) {
        builder.putBitmap(MediaMetadataCompat.METADATA_KEY_ART, art);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return The artist of the media.
     */
    public static String getArtist(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_ARTIST);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                The system defined metadata keys must use the appropriate data type.
     * @param artist The artist of the media.
     */
    public static void setArtist(@NonNull MediaMetadataCompat.Builder builder,
                                 String artist) {
        builder.putString(MediaMetadataCompat.METADATA_KEY_ARTIST, artist);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return The artwork for the media as a {@link Uri}.
     */
    @NonNull
    public static Uri getArtUri(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return StringExt.toUri(mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_ART_URI));
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                The system defined metadata keys must use the appropriate data type.
     * @param artUri The artwork for the media as a {@link Uri}.
     */
    public static void setArtUri(@NonNull MediaMetadataCompat.Builder builder,
                                 Uri artUri) {
        builder.putString(MediaMetadataCompat.METADATA_KEY_ART_URI, StringExt.toString(artUri));
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                The system defined metadata keys must use the appropriate data type.
     * @param artUri The artwork for the media as a Uri style String.
     */
    public static void setArtUri(@NonNull MediaMetadataCompat.Builder builder,
                                 String artUri) {
        builder.putString(MediaMetadataCompat.METADATA_KEY_ART_URI, artUri);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return The author of the media.
     */
    public static String getAuthor(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_AUTHOR);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                The system defined metadata keys must use the appropriate data type.
     * @param author The author of the media.
     */
    public static void setAuthor(@NonNull MediaMetadataCompat.Builder builder,
                                 String author) {
        builder.putString(MediaMetadataCompat.METADATA_KEY_AUTHOR, author);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return The bluetooth folder type of the media specified in the section 6.10.2.2 of the Bluetooth AVRCP 1.5.
     *          It should be one of the following:
     *          {@link MediaDescriptionCompat#BT_FOLDER_TYPE_MIXED}
     *          {@link MediaDescriptionCompat#BT_FOLDER_TYPE_TITLES}
     *          {@link MediaDescriptionCompat#BT_FOLDER_TYPE_ALBUMS}
     *          {@link MediaDescriptionCompat#BT_FOLDER_TYPE_ARTISTS}
     *          {@link MediaDescriptionCompat#BT_FOLDER_TYPE_GENRES}
     *          {@link MediaDescriptionCompat#BT_FOLDER_TYPE_PLAYLISTS}
     *          {@link MediaDescriptionCompat#BT_FOLDER_TYPE_YEARS}
     */
    public static long getBtFolderType(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_BT_FOLDER_TYPE);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                The system defined metadata keys must use the appropriate data type.
     * @param btFolderType The bluetooth folder type of the media specified in the section 6.10.2.2 of the Bluetooth AVRCP 1.5.
     *                      It should be one of the following:
     *                      {@link MediaDescriptionCompat#BT_FOLDER_TYPE_MIXED}
     *                      {@link MediaDescriptionCompat#BT_FOLDER_TYPE_TITLES}
     *                      {@link MediaDescriptionCompat#BT_FOLDER_TYPE_ALBUMS}
     *                      {@link MediaDescriptionCompat#BT_FOLDER_TYPE_ARTISTS}
     *                      {@link MediaDescriptionCompat#BT_FOLDER_TYPE_GENRES}
     *                      {@link MediaDescriptionCompat#BT_FOLDER_TYPE_PLAYLISTS}
     *                      {@link MediaDescriptionCompat#BT_FOLDER_TYPE_YEARS}
     */
    public static void setBtFolderType(@NonNull MediaMetadataCompat.Builder builder,
                                       long btFolderType) {
        builder.putLong(MediaMetadataCompat.METADATA_KEY_BT_FOLDER_TYPE, btFolderType);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return The compilation status of the media
     */
    public static String getCompilation(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_COMPILATION);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                  The system defined metadata keys must use the appropriate data type.
     * @param compilation The compilation status of the media
     */
    public static void setCompilation(@NonNull MediaMetadataCompat.Builder builder,
                                      String compilation) {
        builder.putString(MediaMetadataCompat.METADATA_KEY_COMPILATION, compilation);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return The composer of the media.
     */
    public static String getComposer(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_COMPOSER);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                 The system defined metadata keys must use the appropriate data type.
     * @param composer The composer of the media.
     */
    public static void setComposer(@NonNull MediaMetadataCompat.Builder builder,
                                   String composer) {
        builder.putString(MediaMetadataCompat.METADATA_KEY_COMPOSER, composer);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return The date the media was created or published.
     *          The format is unspecified but RFC 3339 is recommended.
     */
    public static String getDate(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_DATE);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                 The system defined metadata keys must use the appropriate data type.
     * @param date The date the media was created or published.
     *              The format is unspecified but RFC 3339 is recommended.
     */
    public static void setDate(@NonNull MediaMetadataCompat.Builder builder,
                               String date) {
        builder.putString(MediaMetadataCompat.METADATA_KEY_DATE, date);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return The disc number for the media's original source.
     */
    public static long getDiscNumber(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_DISC_NUMBER);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                 The system defined metadata keys must use the appropriate data type.
     * @param discNumber The disc number for the media's original source.
     */
    public static void setDiscNumber(@NonNull MediaMetadataCompat.Builder builder,
                                     long discNumber) {
        builder.putLong(MediaMetadataCompat.METADATA_KEY_DISC_NUMBER, discNumber);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return A description that is suitable for display to the user.
     *          When displaying more information for media described by this metadata
     *          this should be preferred to other fields if present.
     */
    public static String getDisplayDescription(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_DISPLAY_DESCRIPTION);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                 The system defined metadata keys must use the appropriate data type.
     * @param displayDescription A description that is suitable for display to the user.
     *                            When displaying more information for media described by this metadata
     *                            this should be preferred to other fields if present.
     */
    public static void setDisplayDescription(@NonNull MediaMetadataCompat.Builder builder,
                                             String displayDescription) {
        builder.putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_DESCRIPTION, displayDescription);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return An icon or thumbnail that is suitable for display to the user.
     *          When displaying an icon for media described by this metadata this should be preferred to other fields if present.
     *          This must be a {@link Bitmap}. The icon should be relatively small and may be scaled down if it is too large.
     *          For higher resolution artwork {@link #setDisplayIconUri(MediaMetadataCompat.Builder, Uri)} should be used instead.
     */
    public static Bitmap getDisplayIcon(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getBitmap(MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                 The system defined metadata keys must use the appropriate data type.
     * @param displayIcon An icon or thumbnail that is suitable for display to the user.
     *                     When displaying an icon for media described by this metadata this should be preferred to other fields if present.
     *                     This must be a {@link Bitmap}. The icon should be relatively small and may be scaled down if it is too large.
     *                     For higher resolution artwork {@link #setDisplayIconUri(MediaMetadataCompat.Builder, Uri)} should be used instead.
     */
    public static void setDisplayIcon(@NonNull MediaMetadataCompat.Builder builder,
                                      Bitmap displayIcon) {
        builder.putBitmap(MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON, displayIcon);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return An icon or thumbnail that is suitable for display to the user.
     *          When displaying more information for media described by this metadata
     *          the display description should be preferred to other fields when present.
     *          This must be a {@link Uri}.
     */
    @NonNull
    public static Uri getDisplayIconUri(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return StringExt.toUri(mediaMetadataCompat
                .getString(MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON_URI));
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                 The system defined metadata keys must use the appropriate data type.
     * @param displayIconUri An icon or thumbnail that is suitable for display to the user.
     *                        When displaying more information for media described by this metadata
     *                        the display description should be preferred to other fields when present.
     *                        This must be a {@link Uri}.
     */
    public static void setDisplayIconUri(@NonNull MediaMetadataCompat.Builder builder,
                                         Uri displayIconUri) {
        builder.putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON_URI, StringExt.toString(displayIconUri));
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                 The system defined metadata keys must use the appropriate data type.
     * @param displayIconUri An icon or thumbnail that is suitable for display to the user.
     *                        When displaying more information for media described by this metadata
     *                        the display description should be preferred to other fields when present.
     *                        This must be a Uri style String.
     */
    public static void setDisplayIconUri(@NonNull MediaMetadataCompat.Builder builder,
                                         String displayIconUri) {
        builder.putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON_URI, displayIconUri);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return A subtitle that is suitable for display to the user. When displaying a second line
     *          for media described by this metadata this should be preferred to other fields if present.
     */
    public static String getDisplaySubtitle(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_DISPLAY_SUBTITLE);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                 The system defined metadata keys must use the appropriate data type.
     * @param subtitle A subtitle that is suitable for display to the user. When displaying a second line
     *                  for media described by this metadata this should be preferred to other fields if present.
     */
    public static void setDisplaySubtitle(@NonNull MediaMetadataCompat.Builder builder,
                                          String subtitle) {
        builder.putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_SUBTITLE, subtitle);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return A title that is suitable for display to the user.
     *          This will generally be the same as {@link #setTitle(MediaMetadataCompat.Builder, String)}
     *          but may differ for some formats.
     *          When displaying media described by this metadata this should be preferred if present.
     */
    public static String getDisplayTitle(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                 The system defined metadata keys must use the appropriate data type.
     * @param displayTitle A title that is suitable for display to the user.
     *                      This will generally be the same as {@link #setTitle(MediaMetadataCompat.Builder, String)}
     *                      but may differ for some formats.
     *                      When displaying media described by this metadata this should be preferred if present.
     */
    public static void setDisplayTitle(@NonNull MediaMetadataCompat.Builder builder,
                                       String displayTitle) {
        builder.putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE, displayTitle);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return The download status of the media which will be used for later offline playback.
     *          It should be one of the following:
     *          {@link MediaDescriptionCompat#STATUS_NOT_DOWNLOADED}
     *          {@link MediaDescriptionCompat#STATUS_DOWNLOADING}
     *          {@link MediaDescriptionCompat#STATUS_DOWNLOADED}
     */
    public static long getDownloadStatus(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_DOWNLOAD_STATUS);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                 The system defined metadata keys must use the appropriate data type.
     * @param downloadStatus The download status of the media which will be used for later offline playback.
     *                        It should be one of the following:
     *                        {@link MediaDescriptionCompat#STATUS_NOT_DOWNLOADED}
     *                        {@link MediaDescriptionCompat#STATUS_DOWNLOADING}
     *                        {@link MediaDescriptionCompat#STATUS_DOWNLOADED}
     */
    public static void setDownloadStatus(@NonNull MediaMetadataCompat.Builder builder,
                                         long downloadStatus) {
        builder.putLong(MediaMetadataCompat.METADATA_KEY_DOWNLOAD_STATUS, downloadStatus);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return The duration of the media in ms.
     *          A negative duration indicates that the duration is unknown (or infinite).
     */
    public static long getDuration(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                 The system defined metadata keys must use the appropriate data type.
     * @param duration The duration of the media in ms.
     *                  A negative duration indicates that the duration is unknown (or infinite).
     */
    public static void setDuration(@NonNull MediaMetadataCompat.Builder builder,
                                   long duration) {
        builder.putLong(MediaMetadataCompat.METADATA_KEY_DURATION, duration);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return The genre of the media.
     */
    public static String getGenre(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_GENRE);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                 The system defined metadata keys must use the appropriate data type.
     * @param genre The genre of the media.
     */
    public static void setGenre(@NonNull MediaMetadataCompat.Builder builder,
                                String genre) {
        builder.putString(MediaMetadataCompat.METADATA_KEY_GENRE, genre);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return A String key for identifying the content. This value is specific to the service providing the content.
     *          If used, this should be a persistent unique key for the underlying content.
     */
    public static String getMediaId(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                 The system defined metadata keys must use the appropriate data type.
     * @param mediaId A String key for identifying the content. This value is specific to the service providing the content.
     *                 If used, this should be a persistent unique key for the underlying content.
     */
    public static void setMediaId(@NonNull MediaMetadataCompat.Builder builder,
                                  String mediaId) {
        builder.putString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID, mediaId);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return A {@link Uri} representing the content.
     *          This value is specific to the service providing the content.
     *          It may be used with {@link MediaControllerCompat.TransportControls#playFromUri(Uri, Bundle)}
     *          to initiate playback when provided by a {@link MediaBrowserCompat} connected to the same app.
     */
    @NonNull
    public static Uri getMediaUri(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return StringExt.toUri(mediaMetadataCompat
                .getString(MediaMetadataCompat.METADATA_KEY_MEDIA_URI));
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                 The system defined metadata keys must use the appropriate data type.
     * @param mediaUri A {@link Uri} representing the content.
     *                  This value is specific to the service providing the content.
     *                  It may be used with {@link MediaControllerCompat.TransportControls#playFromUri(Uri, Bundle)}
     *                  to initiate playback when provided by a {@link MediaBrowserCompat} connected to the same app.
     */
    public static void setMediaUri(@NonNull MediaMetadataCompat.Builder builder,
                                   Uri mediaUri) {
        builder.putString(MediaMetadataCompat.METADATA_KEY_MEDIA_URI, StringExt.toString(mediaUri));
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                 The system defined metadata keys must use the appropriate data type.
     * @param mediaUri A Uri formatted String representing the content.
     *                  This value is specific to the service providing the content.
     *                  It may be used with {@link MediaControllerCompat.TransportControls#playFromUri(Uri, Bundle)}
     *                  to initiate playback when provided by a {@link MediaBrowserCompat} connected to the same app.
     */
    public static void setMediaUri(@NonNull MediaMetadataCompat.Builder builder,
                                   String mediaUri) {
        builder.putString(MediaMetadataCompat.METADATA_KEY_MEDIA_URI, mediaUri);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return The number of tracks in the media's original source.
     */
    public static long getNumberOfTracks(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_NUM_TRACKS);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                 The system defined metadata keys must use the appropriate data type.
     * @param numberOfTracks The number of tracks in the media's original source.
     */
    public static void setNumberOfTracks(@NonNull MediaMetadataCompat.Builder builder,
                                         long numberOfTracks) {
        builder.putLong(MediaMetadataCompat.METADATA_KEY_NUM_TRACKS, numberOfTracks);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return The overall rating for the media.
     */
    public static long getRating(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_RATING);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                 The system defined metadata keys must use the appropriate data type.
     * @param rating The overall rating for the media.
     */
    public static void setRating(@NonNull MediaMetadataCompat.Builder builder,
                                 long rating) {
        builder.putLong(MediaMetadataCompat.METADATA_KEY_RATING, rating);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return The title of the media.
     */
    public static String getTitle(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_TITLE);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                 The system defined metadata keys must use the appropriate data type.
     * @param title The title of the media.
     */
    public static void setTitle(@NonNull MediaMetadataCompat.Builder builder,
                                String title) {
        builder.putString(MediaMetadataCompat.METADATA_KEY_TITLE, title);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return The track number for the media.
     */
    public static long getTrackNumber(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                 The system defined metadata keys must use the appropriate data type.
     * @param trackNumber The track number for the media.
     */
    public static void setTrackNumber(@NonNull MediaMetadataCompat.Builder builder,
                                      long trackNumber) {
        builder.putLong(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER, trackNumber);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return The user's rating for the media.
     */
    public static long getUserRating(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_USER_RATING);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                 The system defined metadata keys must use the appropriate data type.
     * @param userRating The user's rating for the media.
     */
    public static void setUserRating(@NonNull MediaMetadataCompat.Builder builder,
                                     long userRating) {
        builder.putLong(MediaMetadataCompat.METADATA_KEY_USER_RATING, userRating);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return The writer of the media.
     */
    public static String getWriter(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_WRITER);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                 The system defined metadata keys must use the appropriate data type.
     * @param writer The writer of the media.
     */
    public static void setWriter(@NonNull MediaMetadataCompat.Builder builder,
                                 String writer) {
        builder.putString(MediaMetadataCompat.METADATA_KEY_WRITER, writer);
    }

    /**
     * @param mediaMetadataCompat Contains metadata about an item, such as the title, artist, etc.
     * @return The year the media was created or published as a long.
     */
    public static long getYear(@NonNull MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_YEAR);
    }

    /**
     * @param builder Use to build MediaMetadata objects.
     *                 The system defined metadata keys must use the appropriate data type.
     * @param year The year the media was created or published as a long.
     */
    public static void setYear(@NonNull MediaMetadataCompat.Builder builder, long year) {
        builder.putLong(MediaMetadataCompat.METADATA_KEY_YEAR, year);
    }
}
