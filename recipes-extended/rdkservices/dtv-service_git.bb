# Copyright © 2024 The DTVKit Open Software Foundation Ltd (www.dtvkit.org)
#
# This file is part of a DTVKit Software Component
# You are permitted to copy, modify or distribute this file subject to the terms
# of the DTVKit 1.0 Licence which can be found in licence.txt or at www.dtvkit.org
#
# THIS CODE AND INFORMATION ARE PROVIDED "AS IS" WITHOUT WARRANTY OF ANY KIND,
# EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED WARRANTIES
# OF MERCHANTABILITY AND/OR FITNESS FOR A PARTICULAR PURPOSE.
#
# If you or your organisation is not a member of DTVKit then you have access
# to this source code outside of the terms of the licence agreement
# and you are expected to delete this and any associated files immediately.
# Further information on DTVKit, membership and terms can be found at www.dtvkit.org

SUMMARY = "DTV Thunder service"
DESCRIPTION = "This is the DTV Thunder service for RDK"

DEPENDS = "wpeframework wpeframework-interfaces wpeframework-tools-native dtvkit-dvbcore dtvkit-platform dtvkit-dsmcc"

RDEPENDS_${PN} += "aml-mediahal-sdk aml-dvb cairo essos"

inherit cmake pkgconfig

LICENSE = "DTVKit"
#LIC_FILES_CHKSUM = "file://licence.txt;md5=f9ff7c3a5ee8ecd7a27455cb6b601825"
LIC_FILES_CHKSUM = "file://licence.txt;md5=bb585d051b1c0599f229602d3ea1d31c"

#SRC_URI = "${DTVKIT_GIT}/DTV-Service.git;protocol=${DTVKIT_GIT_PROTOCOL};subpath=service;destsuffix=git;branch=aml_rdk5_main"
SRC_URI = "${OBS_GIT}/DTV-Service;protocol=${OBS_GIT_PROTOCOL};destsuffix=git;branch=main"
#git@github.com:OceanBlueSoftware/DTV-Service.git

#SRCREV = "b7207c002540c14979190c2c12589207a1ad777c"
#SRCREV = "329a53eda478cb7cabc48d238f794f272a9fccdb"
SRCREV = "6986c4b29a741b148cba42497bac59a0ff50c561"

PV = "${RDK_RELEASE}+git${SRCPV}"

S = "${WORKDIR}/git/service"

CXXFLAGS += "-Wno-reorder -Wno-switch"
CXXFLAGS += "${@bb.utils.contains('DISTRO_FEATURES', 'hbbtv', ' -DINCLUDE_HBBTV', '', d)}"

EXTRA_OECMAKE += "-DPLUGIN_DTV_SUBTITLES='true'"
EXTRA_OECMAKE += "-DPLUGIN_DTV_TELETEXT='true'"
EXTRA_OECMAKE += "-DPLUGIN_DTV_CLIENTIDENTIFIER='dtv-service'"
EXTRA_OECMAKE += "-DPLUGIN_DTV_TARGETLIBS='-lmediahal_tsplayer -lam_adp -lessosrmgr -lessos -lcairo'"

FILES_SOLIBSDEV = ""
FILES_${PN} = "${libdir}/wpeframework/plugins/*.so"
FILES_${PN} += "${sysconfdir}/WPEFramework/plugins/DTV.json"


