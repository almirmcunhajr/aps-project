'use client';

import { useEffect, useState } from "react";
import Link from "next/link";
import Image from "next/image";
import { usePathname, useRouter } from "next/navigation";

import Button from "@/components/Button";

import { UserType } from "@types";

const Navbar = () => {
  const pathname = usePathname();
  const router = useRouter();
  const [reload, setReload] = useState<boolean>(false);

  const [user, setUser] = useState<UserType>({});

  useEffect(() => {
    setUser(JSON.parse(localStorage?.getItem('user') ?? '{}'));
  }, [reload, pathname]);
  
  const logout = () => {
    localStorage.clear();
    router.refresh();
    setReload(!reload)
  }

  return (
    <header className="w-full absolute z-10 border-b border-gray-100 bg-slate-100">
      <nav className="max-w-[1440px] mx-auto flex justify-between items-center sm:px-16 px-6 py-4">
        <Link className="flex justify-center items-center"
          href={'/'}
        >
          <Image className="object-contain"
            alt="Logo"
            height={18}
            src='/logo.png'
            width={118}
          />
        </Link>

        {!!user?.name ? (
          <div className="flex flex-row gap-4"
            onClick={logout}
          >
            Olá, {user?.name}!
            <div className="cursor-pointer text-zinc-400">
              Sair
            </div>
          </div>
        ) : (
          <Link
            href={'/login'}
          >
            <Button
              containerStyles="flex flex-row relative justify-center items-center py-3 px-6 outline-none text-white rounded-full bg-primary-blue min-w-[130px]"
              title="Entrar"
              type="button"
            />
          </Link>
        )}
      </nav>
    </header>
  )
}

export default Navbar;