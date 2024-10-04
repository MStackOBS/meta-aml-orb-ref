
DESCRIPTION = "Recipe to build ipv6calc library"
HOMEPAGE = "http://pkgs.fedoraproject.org/lookaside/pkgs/ipv6calc"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=df7b533e1ebb65cf315510ab93b9313a \
                    file://LICENSE;md5=00fc396bf7f607c7d40d5348ac7a7fcc \
                   "
SRC_URI = "https://www.deepspace6.net/ftp/pub/ds6/sources/ipv6calc/ipv6calc-${PV}.tar.gz"
SRC_URI[md5sum] = "aa3c0bb7267bc98d50c12f6b5ca4504f"
SRC_URI[sha256sum] = "b0bc5d2f83c928524f82053b40f670589bd0181719046a2e4c267912a2ba1d28"

SRC_URI += "file://configure.patch"
SRC_URI_append_kirkstone = " file://fix_multiple_definition_error_gcc_10.patch"

inherit autotools pkgconfig

B = "${S}"
PACKAGECONFIG ??= "nowarn"
PACKAGECONFIG_remove_morty = "nowarn"
PACKAGECONFIG[nowarn] = "--disable-compiler-warning-to-error"
RDEPENDS_ipv6calc = " bash perl"
do_install_append() {
	install -d ${D}${libdir}
	install -m 0755 ${S}/lib/libipv6calc.so.0.99.1 ${D}${libdir}
}

PACKAGES =+ "${PN}-main ${PN}-log"
FILES_${PN}-main = "${bindir}/ipv6calc"
FILES_${PN}-log = "${bindir}/ipv6logconv ${bindir}/ipv6loganon ${bindir}/ipv6logstats"
