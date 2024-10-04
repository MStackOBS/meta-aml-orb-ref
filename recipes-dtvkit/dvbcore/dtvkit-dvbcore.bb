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

SUMMARY = "DTVKit DVB stack"
DESCRIPTION = "This is the DTVKit DVB stack"
HOMEPAGE = "https://www.dtvkit.org/"

SECTION = ""
DEPENDS = "sqlite3 libpng openjpeg zlib"

LICENSE = "DTVKit"
LIC_FILES_CHKSUM = "file://licence.txt;md5=4088684cf0509118febcf059b97b4cad"

# use the elaraby branch
#SRC_URI = "${OBS_GIT}/DVBCore.git;protocol=${OBS_GIT_PROTOCOL};branch=elaraby"
SRC_URI = "${OBS_GIT}/DVBCore.git;protocol=${OBS_GIT_PROTOCOL};branch=master"
#SRCREV = "b41e69ac10fcc23dde0c99b8935f705a129ffb08"
#SRCREV = "9c3011908c44424da91394296ac5b852c3d747f0"
SRCREV = "7ed809cb3969497dfedc353c497cc89f9c838a67"

PV = "${RDK_RELEASE}+git${SRCPV}"
S = "${WORKDIR}/git"

EXTRA_OEMAKE = "'DTVKIT_CC=${CC}' 'DTVKIT_AR=${AR}'"
EXTRA_OEMAKE += "'DTVKIT_ADDITIONAL_COMPILER_OPTIONS=-fPIC'"
EXTRA_OEMAKE += "'DTVKIT_COUNTRY_GERMANY=1'"
EXTRA_OEMAKE += "'DTVKIT_COUNTRY_UK=1'"
EXTRA_OEMAKE += "'DTVKIT_EIT_REPORT_SEGMENTS=1'"
EXTRA_OEMAKE += "'DTVKIT_INTEGRATE_SQLITE=1'"
EXTRA_OEMAKE += "'DTVKIT_DEFAULT_SQLITE_FILE=/data/dtvkit.sqlite3'"
EXTRA_OEMAKE += "'DTVKIT_JPEG_INCLUDE_PATH=${STAGING_INCDIR}${includedir}'"
EXTRA_OEMAKE += "'DTVKIT_PNG_INCLUDE_PATH=${STAGING_INCDIR}${includedir}'"
EXTRA_OEMAKE += "'DTVKIT_ZLIB_INCLUDE_PATH=${STAGING_INCDIR}${includedir}'"
EXTRA_OEMAKE += "'DTVKIT_HBBTV_INCLUDE_PATH=$(DVBCORE_ROOT)/externals/HBBTV/inc'"
EXTRA_OEMAKE += "'DTVKIT_INCLUDE_HBBTV=2'"
EXTRA_OEMAKE += "'QUIET='"

do_install() {
   oe_runmake -C ${S} install INSTALL_INC_PATH=${D}${includedir}/dtvkit INSTALL_LIB_PATH=${D}${libdir}
}

#EXTERNALSRC_pn-dtvkit-dvbcore = "${RDK_ROOT_PATH}/localsrc/DVBCore"

