DESCRIPTION = "Open source SIP stack and media stack for presence, im/instant \
               messaging, and multimedia communication"
SECTION = "libs"
HOMEPAGE = "http://www.pjsip.org/"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=477ab0a4c8ca64b482b3f2a365d0fdfa"
DEPENDS = "alsa-lib openssl"

PARALLEL_MAKE = ""

SRC_URI = "http://www.pjsip.org/release/${PV}/pjproject-${PV}.tar.bz2 "
SRC_URI[md5sum] = "05428502384c16e7abd85f047e6e2f6c"
SRC_URI[sha256sum] = "1d5fd0c90068c671b1942950b507a929a4007a04977b8b17ec6fa1464733ee46"

S = "${WORKDIR}/pjproject-${PV}"

inherit autotools pkgconfig

do_configure_prepend() {
        export AR="${HOST_SYS}-ar rv"
        export LD="${CC}"
}

do_compile_prepend() {
        oe_runmake dep
}
