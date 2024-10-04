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

SUMMARY = "Amlogic RDK DTVKit HAL layer"
DESCRIPTION = "This is the DTVKit HAL layer code for Amlogic boards"
HOMEPAGE = "https://www.dtvkit.org/"

SECTION = ""
DEPENDS = "dtvkit-dvbcore aml-mp-sdk essos cairo iarmbus iarmmgrs-hal-headers"

LICENSE = "CLOSED"
#LIC_FILES_CHKSUM = "file://licence.txt;md5=f9ff7c3a5ee8ecd7a27455cb6b601825"
#LIC_FILES_CHKSUM = ""


 
#SRC_URI = "${OBS_GIT}/AMLogic_T962X;protocol=${OBS_GIT_PROTOCOL};branch=master"
SRC_URI = "${OBS_GIT}/AMLogic_T962X.git;branch=rdk"

#SRCREV = "a6a462b72eb954c1ed35f6239a6371f772a6bc4c"
#SRCREV = "3c746762333cf0c245aa612436d48fdb81a8a3f1"
#SRCREV = "255aec6831da712f03a7159f8865d061ce5b482d"
SRCREV = "fab2874a257dcfb48b697f68e6fc29532a3ca5fb"

PV = "${RDK_RELEASE}+git${SRCPV}"
S = "${WORKDIR}/git"

EXTRA_OEMAKE = "'DTVKIT_CC=${CC}' 'DTVKIT_AR=${AR}'"
EXTRA_OEMAKE += "'DTVKIT_ADDITIONAL_COMPILER_OPTIONS=-fPIC -DMESONT5W_AT301'"
#EXTRA_OEMAKE += "'DTVKIT_ADDITIONAL_COMPILER_OPTIONS=-fPIC -DMESONT5W_AT301 -DINCLUDE_PVR'"
EXTRA_OEMAKE += "'DTVKIT_ADDITIONAL_COMPILER_OPTIONS+=-I${STAGING_INCDIR}/rdk/iarmbus'"
EXTRA_OEMAKE += "'DTVKIT_ADDITIONAL_COMPILER_OPTIONS+=-I${STAGING_INCDIR}/rdk/iarmmgrs-hal'"
EXTRA_OEMAKE += "'DTVKIT_DVBCORE_ROOT=${STAGING_INCDIR}/dtvkit'"
EXTRA_OEMAKE += "'DTVKIT_INTEGRATE_SQLITE=1'"
EXTRA_OEMAKE += "'DTVKIT_OUTPUT_DIR=${B}'"

do_compile() {
   oe_runmake -C ${S} all QUIET=
}

do_install() {
   install -d ${D}${libdir}
   oe_runmake -C ${S}/os install INSTALL_LIB_PATH=${D}${libdir}
   oe_runmake -C ${S}/hw install INSTALL_LIB_PATH=${D}${libdir}
}

#EXTERNALSRC_pn-dtvkit-platform = "${RDK_ROOT_PATH}/localsrc/AMLogic_T962X"

