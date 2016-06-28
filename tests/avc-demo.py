#! /usr/bin/env python
# -*- coding: utf-8 -*-

'''
Copyright (C) 2016 Meizu Technology Co,. Ltd.  - http://www.meizu.com/
@author: Jeron <zengzhiyong@meizu.com>
'''

import re
import sys
import os
import time
import re

from com.dtmilano.android.viewclient import ViewClient, ViewNotFoundException

kwargs1 = {'ignoreversioncheck': False, 'verbose': False, 'ignoresecuredevice': False}
device, serialno = ViewClient.connectToDeviceOrExit(**kwargs1)
kwargs2 = {'forceviewserveruse': False, 'useuiautomatorhelper': False, 'ignoreuiautomatorkilled': True, 'autodump': False, 'startviewserver': True, 'compresseddump': True}
vc = ViewClient(device, serialno, **kwargs2)

def dump_always ():
    success = False
    while not success:
        try:
            vc.dump()
            success = True
        except RuntimeError:
            print("Got RuntimeError when call vc.dump()")
            time.sleep(5)
        except ValueError:
            print("Got ValueError when call vc.dump()")
            time.sleep(5)
	    
def screenshot ():
	
	filename = 'screenshot'
	device.takeSnapshot().save(filename, 'PNG')
	
contents = [
		u'CulebraTester 1 - ViewClient',
		u'CulebraTester 2 - ViewClient',
		u'CulebraTester 3 - ViewClient',
		u'CulebraTester 4 - ViewClient',
		u'CulebraTester 5 - ViewClient',
		]

def getViewWithContentDesc (
	contentDesc,
	):
	
	parentView = vc.findViewWithText(contentDesc)
		
	if parentView:
		viewUid = parentView.getUniqueId()
		uid = int(re.search("id/no_id/(?P<uid>\d+)", viewUid).group('uid'))
		
		childView1 = vc.findViewByIdOrRaise("id/no_id/%s" % (uid + 0))
		childText1 = childView1.getText().strip().encode('utf-8').strip()
		
		childView2 = vc.findViewByIdOrRaise("id/no_id/%s" % (uid + 1))
		childText2 = childView2.getText().strip().encode('utf-8').strip()

def touch ():

	view = vc.findViewWithText('CulebraTester 1 - ViewClient')
	
	if view:
		view.touch()

def drag ():

	view = vc.findViewWithText('CulebraTester 4 - ViewClient')
	
	if view:
		view.touch()
		dump_always()
		
		# Drag down to get rest of the test score
		device.drag((300,1000), (300,100), 500)

def inputText ():

	view = vc.findViewByIdOrRaise("com.meizu.culebratesterdemo:id/item_text")
	
	if view:
		view.type('0123456789')
		
def doTest ():
	print 'AVC Demo run on device %s' % serialno
	
	dump_always()
	
	#screenshot()
	#getViewWithContentDesc(contents[0])
	#touch()
	#drag()
	#inputText()
	
if __name__ == '__main__':
	
	doTest()
