########################################################################
# Copyright © 2024 Ocean Blue Software Ltd (www.oceanbluesoftware.co.uk)
# This document is the CONFIDENTIAL property of Ocean Blue Software Ltd.
########################################################################

SRCREV_pn-wpe-webkit = "07fdc0799c2f5a1c1b636531cf8f8d260d967e94"

DEPENDS +=  " ${@bb.utils.contains('DISTRO_FEATURES','widevine','  aml-mediadrm-widevine gst-aml-drm-plugins','',d)}"
DEPENDS += " rdkservices"
RDEPENDS_${PN} += " rdkservices"

PACKAGECONFIG[aml-mediadrm-widevine] = "-DENABLE_SECMEM=ON,-DENABLE_SECMEM=OFF"
PACKAGECONFIG_remove = " playready ${PROVISIONING} native_audio"
PACKAGECONFIG_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'rdkv-client','mediastream' , '', d)}"
PACKAGECONFIG[platform_amlogic] = "-DUSE_WPEWEBKIT_PLATFORM_AMLOGIC=ON, -DUSE_WPEWEBKIT_PLATFORM_AMLOGIC=OFF,"
PACKAGECONFIG_append  = " platform_amlogic"

PACKAGECONFIG_append = " hevc"
# enable HDR support
PACKAGECONFIG_append= " vp9 vp9_hdr "
#enable web audio
PACKAGECONFIG_append = " webaudio"
#enable indexedDB
PACKAGECONFIG_append = " indexeddb"

PARALLEL_MAKE_pn-wpe-webkit = ""

RDEPS_EXTRA = " \
               gstreamer1.0-plugins-base-audioconvert \
               gstreamer1.0-plugins-base-audioresample \
               gstreamer1.0-plugins-base-gio \
               gstreamer1.0-plugins-base-typefindfunctions \
               gstreamer1.0-plugins-good-audiofx \
               gstreamer1.0-plugins-good-audioparsers \
               gstreamer1.0-plugins-good-autodetect \
               gstreamer1.0-plugins-good-avi \
               gstreamer1.0-plugins-bad-dashdemux \
               gstreamer1.0-plugins-bad-hls \
               gstreamer1.0-plugins-bad-mpegtsdemux \
               gstreamer1.0-plugins-bad-smoothstreaming \
               gstreamer1.0-plugins-bad-videoparsersbad \
               shared-mime-info \
               "
#For license issue
RDEPS_EXTRA_remove = " gstreamer1.0-plugins-bad-smoothstreaming \
               "

