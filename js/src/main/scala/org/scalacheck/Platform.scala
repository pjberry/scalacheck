/*-------------------------------------------------------------------------*\
**  ScalaCheck                                                             **
**  Copyright (c) 2007-2018 Rickard Nilsson. All rights reserved.          **
**  http://www.scalacheck.org                                              **
**                                                                         **
**  This software is released under the terms of the Revised BSD License.  **
**  There is NO WARRANTY. See the file LICENSE for the full text.          **
\*------------------------------------------------------------------------ */

package org.scalacheck

import Test._

private[scalacheck] object Platform {

  def runWorkers(
    params: Parameters,
    workerFun: Int => Result,
    stop: () => Unit
  ): Result = {
    workerFun(0)
  }

  def loadModule(name: String, loader: ClassLoader): AnyRef =
    org.scalajs.testinterface.TestUtils.loadModule(name, loader)

  def newInstance(name: String, loader: ClassLoader, paramTypes: Seq[Class[_]])(args: Seq[AnyRef]): AnyRef =
    org.scalajs.testinterface.TestUtils.newInstance(name, loader, paramTypes)(args)

  type EnableReflectiveInstantiation = scala.scalajs.reflect.annotation.EnableReflectiveInstantiation
}
