SUMMARY = "rpi-radio"
SECTION = "qt/apps"
HOMEPAGE = "https://github.com/heinervdm/rpi-radio"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

PV = "0.0+gitr${SRCPV}"

SRCREV = "${AUTOREV}"

inherit qt4e cmake

SRC_URI = " \
    git://github.com/heinervdm/rpi-radio.git \
"

S = "${WORKDIR}/git"

export EXTRA_OECMAKE="-DQT_LIBRARY_DIR=${OE_QMAKE_LIBDIR_QT} \
                      -DQT_INSTALL_LIBS=${OE_QMAKE_LIBDIR_QT} \
                      -DQT_INCLUDE_DIR=${OE_QMAKE_INCDIR_QT} \
                      -DQT_HEADERS_DIR=${OE_QMAKE_INCDIR_QT} \
                      -DQT_MOC_EXECUTABLE=${OE_QMAKE_MOC} \
                      -DQT_UIC_EXECUTABLE=${OE_QMAKE_UIC} \
                      -DQT_UIC3_EXECUTABLE=${OE_QMAKE_UIC3} \
                      -DQT_RCC_EXECUTABLE=${OE_QMAKE_RCC} \
                      -DQT_QMAKE_EXECUTABLE=${OE_QMAKE_QMAKE} \
                      -DQT_QTCORE_INCLUDE_DIR=${OE_QMAKE_INCDIR_QT}/QtCore \
                     "

do_install() {
    oe_runmake install DESTDIR=${D}
}
