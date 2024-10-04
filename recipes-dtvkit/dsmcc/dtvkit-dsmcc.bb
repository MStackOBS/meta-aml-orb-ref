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

SUMMARY = "DTVKit DSMCC"
DESCRIPTION = "This is the DSMCC lib"
HOMEPAGE = "https://www.dtvkit.org/"

SECTION = ""
DEPENDS = "zlib"

LICENSE = "DTVKit"
LIC_FILES_CHKSUM = "file://licence.txt;md5=f9ff7c3a5ee8ecd7a27455cb6b601825"

SRC_URI = "${DTVKIT_GIT}/DSMCC.git;protocol=${DTVKIT_GIT_PROTOCOL};branch=master"
SRCREV = "ccefc7c414cb72dd8fd42257509ac6f2deb53317"

PV = "${RDK_RELEASE}+git${SRCPV}"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "'DTVKIT_OSTYPE=linux-gnu'"
EXTRA_OEMAKE += "'DTVKIT_CC=${CC} -fPIC' 'DTVKIT_AR=${AR}'"
EXTRA_OEMAKE += "'DTVKIT_USE_STDINT=0'"
EXTRA_OEMAKE += "'DTVKIT_DSMCC_DEBUG_LEVEL=0'"
EXTRA_OEMAKE += "'DTVKIT_DSMCC_DEBUG_MASK=0x0000'"
EXTRA_OEMAKE += "'DTVKIT_ZLIB_INCLUDE_PATH=${STAGING_INCDIR}${includedir}'"

# clear PARALLEL_MAKE variable as a workaround (race conditions)
PARALLEL_MAKE = ""

do_install() {
   oe_runmake install INSTALL_INC_PATH=${D}${includedir}/dtvkit/dsmcc/inc INSTALL_LIB_PATH=${D}${libdir}
}
