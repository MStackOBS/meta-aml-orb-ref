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

SUMMARY = "ORB Platform implementation"
DESCRIPTION = "An implementation using ORB API"

inherit cmake pkgconfig

DEPENDS = "wpeframework-interfaces orb orb-browser-plugin"

LICENSE = "Apache-2.0"
#LIC_FILES_CHKSUM = "file://LICENSE;md5=b1e01b26bacfc2232046c90a330332b3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0527125ba49a2641b7a1ddffadd95516"

#SRC_URI = "${DTVKIT_GIT}/ORBPlatform.git;protocol=${DTVKIT_GIT_PROTOCOL};branch=aml_rdk5_main"
#SRC_URI = "${OBS_GIT}/ORBPlatform.git;protocol=${OBS_GIT_PROTOCOL};branch=master"
SRC_URI = "${OBS_GIT}/ORBPlatform.git;protocol=${OBS_GIT_PROTOCOL};branch=aml_rdk5"
#SRC_URI = "${OBS_GIT}/ORBPlatform.git;protocol=${OBS_GIT_PROTOCOL};branch=rdk5"
#SRCREV = "906fe35d8e601290bc475e1c691fb14b8dcf007d"
#SRCREV = "9e1d4b5947bba67410c8e61f7a0a16942504ed33"
#SRCREV = "e021aaeaee4f3c77008b018d77ea1ba8081b7d90"
#SRCREV = "47d173ac7fb94c746c22c3fb3685c9188b98793f"
SRCREV = "996db8cc82ec948aee04f85fe96feccd2e92784a"

PV = "${RDK_RELEASE}+git${SRCPV}"

S = "${WORKDIR}/git"

TOOLCHAIN = "gcc"

# set the actual sysroot for CMAKE -- This will set the CMAKE_MODULE PATH
EXTRA_OECMAKE += "-DCMAKE_SYSROOT=${STAGING_DIR_HOST}"
EXTRA_OECMAKE += "-DRDKSHELL_BEHIND=residentapp"

FILES_${PN} += "/usr/lib/*.so"
FILES_${PN}-dev = ""

#EXTERNALSRC_pn-orb-platform = "${RDK_ROOT_PATH}/localsrc/ORBPlatform"

