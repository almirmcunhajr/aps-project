'use client';

import { useState } from "react";

import { Button, Input } from "@/components"
import { useRouter } from "next/navigation";

const LoginPage = () => {
  const router = useRouter();

  const user = JSON.parse(localStorage.getItem('user') ?? '{}');

  const [email, setEmail] = useState<string>('');
  const [password, setPassword] = useState<string>('');

  const forgotPassword = () => {
    
  }

  const login = () => {
    localStorage.setItem('user', JSON.stringify({email: 'mms9@cin.ufpe.br', name: 'Marvin Miguel'}));
    router.refresh();
  }

  const loginWithGoogle = () => {
    localStorage.setItem('user', JSON.stringify({email: 'mms9@cin.ufpe.br', name: 'Marvin Miguel 2'}));
    router.refresh();
  }

  if (!!user?.name) {
    router.push('/');
  }
  
  return (
    <div className="w-full min-h-screen flex justify-center items-center">
      <div className="flex flex-col justify-between min-w-[500px] min-h-[250px] p-5 rounded-md bg-slate-100">
        <div className="flex flex-col flex-1 gap-2">
          <Input
            onChange={setEmail}
            placeholder="E-mail"
            value={email}
          />
          <Input
            autocomplete="off"
            onChange={setPassword}
            placeholder="Senha"
            value={password}
          />
          <div className="flex flex-row justify-between items-center">
            <Button
              containerStyles="text-black"
              handleClick={forgotPassword}
              title="Esqueci a senha"
            />
            <Button
              containerStyles="text-black"
              handleClick={login}
              title="Entrar"
            />
          </div>
        </div>
        <Button
          containerStyles="flex flex-row relative justify-center items-center py-3 px-6 outline-none text-white rounded-full bg-primary-blue"
          handleClick={loginWithGoogle}
          title="Logar com Google"
        />
      </div>
    </div>
  )
}

export default LoginPage;