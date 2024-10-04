########################################################################
# Copyright © 2022 Ocean Blue Software Ltd (www.oceanbluesoftware.co.uk)
#  This document is the CONFIDENTIAL property of Ocean Blue Software Ltd.
########################################################################

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = "${@bb.utils.contains('DISTRO_FEATURES', 'dvb', ' file://appmanagerregistry.conf', '', d)}"

do_install_append() {
   
   if [ "${@bb.utils.contains('DISTRO_FEATURES', 'dvb', 'yes', 'no', d)}" = "yes" ]; then
      install -d ${D}/www
      install -D -t ${D}/etc/ -m 644 ${WORKDIR}/appmanagerregistry.conf 
   fi
   
}

FILES_${PN} += "/etc/appmanagerregistry.conf"

